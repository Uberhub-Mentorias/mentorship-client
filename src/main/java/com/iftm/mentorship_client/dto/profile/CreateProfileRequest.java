package com.iftm.mentorship_client.dto.profile;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DTO for profile creation request.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request to create a new mentor/mentee profile")
public class CreateProfileRequest {
    
    @NotBlank(message = "Mini bio é obrigatória")
    @Size(min = 10, max = 500, message = "Mini bio deve ter entre 10 e 500 caracteres")
    @Schema(description = "Short biography of the mentor/mentee", example = "Desenvolvedor Full Stack com 10 anos de experiência em Java e Spring", requiredMode = Schema.RequiredMode.REQUIRED)
    private String miniBio;
    
    @NotNull(message = "Áreas de conhecimento são obrigatórias")
    @Size(min = 1, message = "Pelo menos uma área de conhecimento é obrigatória")
    @Schema(description = "List of expertise areas", example = "[\"Java\", \"Spring Boot\", \"Microservices\"]", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> areas;
    
    @Schema(description = "Link for scheduling meetings (e.g., Calendly)", example = "https://calendly.com/mentor-name")
    private String schedulingLink;
}
