package com.iftm.mentorship_client.dto.profile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

/**
 * DTO for profile response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Profile response with full details")
public class ProfileResponseDTO {
    
    @Schema(description = "Profile unique identifier", example = "507f1f77bcf86cd799439011")
    private String id;
    
    @Schema(description = "User ID (mentor/mentee)", example = "675535d1d7a88c67ef31ef76")
    private String mentorId;
    
    @Schema(description = "Short biography", example = "Desenvolvedor Full Stack com 10 anos de experiência")
    private String miniBio;
    
    @Schema(description = "List of expertise areas", example = "[\"Java\", \"Spring Boot\", \"Microservices\"]")
    private List<String> areas;
    
    @Schema(description = "Link for scheduling meetings", example = "https://calendly.com/mentor-name")
    private String schedulingLink;
    
    @Schema(description = "Profile status", example = "APPROVED", allowableValues = {"DRAFT", "PENDING", "APPROVED", "REJECTED"})
    private String status;
    
    @Schema(description = "Profile creation timestamp", example = "2024-12-08T10:30:00Z")
    private Instant createdAt;
    
    @Schema(description = "Profile last update timestamp", example = "2024-12-08T15:45:00Z")
    private Instant updatedAt;
    
    @Schema(description = "Profile approval timestamp", example = "2024-12-08T16:00:00Z")
    private Instant approvedAt;
    
    @Schema(description = "Admin ID who approved the profile", example = "675535d1d7a88c67ef31ef77")
    private String approvedBy;
}
