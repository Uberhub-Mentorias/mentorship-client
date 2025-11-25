# Mentorship Service Client Library

A lightweight Java client library for sharing DTOs across microservices in the Uberhub Mentorias platform. This library provides common data transfer objects and client implementations to facilitate communication between microservices.

## Overview

This client library eliminates the need to duplicate DTO classes across microservices. It provides:

- ✅ **Pre-built DTOs** - Request and Response objects with validation
- ✅ **Type Safety** - Compile-time validation of API contracts
- ✅ **Easy Integration** - Multiple client implementations (RestTemplate, WebClient, Feign)
- ✅ **Lombok Support** - Builder pattern and clean APIs
- ✅ **OpenAPI Compatible** - Includes Swagger annotations

## Installation

### Maven

Add this dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.iftm</groupId>
    <artifactId>mentorship-client</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### Gradle

```gradle
implementation 'com.iftm:mentorship-client:1.0-SNAPSHOT'
```

## Available DTOs

### MatchmakingRequestDTO

Request object for finding a mentor match based on expertise tags.

```java
package com.iftm.mentorship_client.dto;

import java.util.List;

public class MatchmakingRequestDTO {
    private List<String> tags; // Required, cannot be empty
}
```

**Example:**
```java
MatchmakingRequestDTO request = MatchmakingRequestDTO.builder()
    .tags(Arrays.asList("java", "spring-boot", "microservices"))
    .build();
```

### MatchmakingResponseDTO

Response object containing the matched mentor information.

```java
package com.iftm.mentorship_client.dto;

public class MatchmakingResponseDTO {
    private String mentorId;  // ID of matched mentor (null if no match)
    private String message;   // Result message
}
```

**Example:**
```java
MatchmakingResponseDTO response = // ... from API call
String mentorId = response.getMentorId();
String message = response.getMessage();
```

## Client Implementations

### Option 1: RestTemplate (Synchronous)

Simple synchronous HTTP client using Spring's RestTemplate.

```java
import com.iftm.mentorship_client.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class MatchmakingClient {
    
    private final RestTemplate restTemplate;
    private final String baseUrl;
    
    public MatchmakingClient(
            RestTemplate restTemplate,
            @Value("${matchmaking.service.url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }
    
    public MatchmakingResponseDTO findBestMatch(List<String> tags) {
        MatchmakingRequestDTO request = MatchmakingRequestDTO.builder()
            .tags(tags)
            .build();
            
        return restTemplate.postForObject(
            baseUrl + "/api/v1/matchmaking",
            request,
            MatchmakingResponseDTO.class
        );
    }
}
```

### Option 2: WebClient (Reactive)

Reactive HTTP client for non-blocking operations.

```java
import com.iftm.mentorship_client.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MatchmakingClient {
    
    private final WebClient webClient;
    
    public MatchmakingClient(
            WebClient.Builder webClientBuilder,
            @Value("${matchmaking.service.url}") String baseUrl) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }
    
    public Mono<MatchmakingResponseDTO> findBestMatch(List<String> tags) {
        MatchmakingRequestDTO request = MatchmakingRequestDTO.builder()
            .tags(tags)
            .build();
            
        return webClient.post()
            .uri("/api/v1/matchmaking")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(MatchmakingResponseDTO.class);
    }
}
```

### Option 3: OpenFeign (Declarative)

Declarative REST client with minimal boilerplate.

**Add Feign Dependency:**
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

**Enable Feign in your Application:**
```java
@SpringBootApplication
@EnableFeignClients
public class YourApplication {
    public static void main(String[] args) {
        SpringApplication.run(YourApplication.class, args);
    }
}
```

**Create Feign Client:**
```java
import com.iftm.mentorship_client.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
    name = "matchmaking-service",
    url = "${matchmaking.service.url}"
)
public interface MatchmakingClient {
    
    @PostMapping("/api/v1/matchmaking")
    MatchmakingResponseDTO findBestMatch(
        @RequestBody MatchmakingRequestDTO request
    );
}
```

## Configuration

Configure the target microservice URL in your `application.yml` or `application.properties`.

### Example for Matchmaking Service

#### application.yml
```yaml
matchmaking:
  service:
    url: http://localhost:8082
```

### application.properties
```properties
matchmaking.service.url=http://localhost:8082
```

## Usage Example: Integration with Other Microservices

Here's a complete example of integrating the client DTOs into another microservice.

### Example: Mentorship Service using Matchmaking DTOs

```java
import com.iftm.mentorship_client.dto.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MentorshipService {
    
    private final MatchmakingClient matchmakingClient;
    private final MentorshipRepository mentorshipRepository;
    
    public MentorshipResponseDTO createMentorship(MentorshipCreateDTO request) {
        log.info("Creating mentorship for tags: {}", request.getExpertiseTags());
        
        // Step 1: Find best mentor match
        MatchmakingResponseDTO matchResult = matchmakingClient
            .findBestMatch(request.getExpertiseTags());
        
        // Step 2: Validate match result
        if (matchResult.getMentorId() == null) {
            log.warn("No mentor found: {}", matchResult.getMessage());
            throw new NoMentorAvailableException(matchResult.getMessage());
        }
        
        log.info("Found mentor: {}", matchResult.getMentorId());
        
        // Step 3: Create mentorship with matched mentor
        Mentorship mentorship = Mentorship.builder()
            .mentorId(matchResult.getMentorId())
            .menteeId(request.getMenteeId())
            .expertiseTags(request.getExpertiseTags())
            .status(MentorshipStatus.PENDING)
            .createdAt(LocalDateTime.now())
            .build();
        
        mentorship = mentorshipRepository.save(mentorship);
        
        return mapToResponseDTO(mentorship);
    }
}
```

## Error Handling

The client should handle potential errors from the Matchmaking Service:

```java
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

@Service
public class MatchmakingClientWrapper {
    
    private final MatchmakingClient matchmakingClient;
    
    public Optional<MatchmakingResponseDTO> findBestMatchSafely(List<String> tags) {
        try {
            MatchmakingResponseDTO response = matchmakingClient.findBestMatch(tags);
            return Optional.ofNullable(response);
            
        } catch (HttpClientErrorException.BadRequest e) {
            log.error("Invalid request: {}", e.getMessage());
            return Optional.empty();
            
        } catch (HttpClientErrorException.NotFound e) {
            log.warn("No mentor found for tags: {}", tags);
            return Optional.empty();
            
        } catch (ResourceAccessException e) {
            log.error("Matchmaking service unavailable: {}", e.getMessage());
            throw new ServiceUnavailableException("Matchmaking service is down");
        }
    }
}
```

## Testing

### Mock Client in Unit Tests

```java
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;

class MentorshipServiceTest {
    
    @Mock
    private MatchmakingClient matchmakingClient;
    
    @InjectMocks
    private MentorshipService mentorshipService;
    
    @Test
    void shouldCreateMentorshipWhenMentorFound() {
        // Given
        List<String> tags = Arrays.asList("java", "spring");
        
        MatchmakingResponseDTO matchResponse = MatchmakingResponseDTO.builder()
            .mentorId("mentor-123")
            .message("Successfully matched")
            .build();
        
        when(matchmakingClient.findBestMatch(tags))
            .thenReturn(matchResponse);
        
        // When
        MentorshipCreateDTO request = new MentorshipCreateDTO(/* ... */);
        MentorshipResponseDTO result = mentorshipService.createMentorship(request);
        
        // Then
        assertNotNull(result);
        assertEquals("mentor-123", result.getMentorId());
        verify(matchmakingClient).findBestMatch(tags);
    }
}
```

## Microservices Using This Library

This client library is used by multiple microservices in the Uberhub Mentorias platform:

### Matchmaking Service

The Matchmaking Service provides the following endpoints:

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/matchmaking` | Find best mentor match |
| GET | `/actuator/health` | Health check |
| GET | `/swagger-ui.html` | API Documentation |
| GET | `/api-docs` | OpenAPI JSON |

### Other Services

Other microservices can use the DTOs from this library to communicate with each other, ensuring type safety and consistency across the platform.

## Requirements

- Java 17+
- Spring Boot 3.x
- Lombok

## Dependencies

This client library requires:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.7.0</version>
    </dependency>
</dependencies>
```

## Support

For issues or questions:
- **Repository**: https://github.com/Uberhub-Mentorias/mentorship-client
- **Platform**: https://github.com/Uberhub-Mentorias

## License

This project is part of the Uberhub Mentorias platform.

---

**Version**: 1.0-SNAPSHOT  
**Last Updated**: November 25, 2025