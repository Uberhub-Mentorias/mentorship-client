package com.iftm.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request object for finding a mentor match")
public class MatchmakingRequestDTO {
    
    @NotEmpty(message = "Tags list cannot be empty")
    @Schema(
            description = "List of expertise tags to match with mentors",
            example = "[\"java\", \"spring-boot\", \"microservices\"]",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private List<String> tags;
}
