package com.iftm.mentorship_client.dto.profile;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DTO for profile update request.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request to update an existing profile")
public class UpdateProfileRequest {
    
    @Size(min = 10, max = 500, message = "Mini bio deve ter entre 10 e 500 caracteres")
    @Schema(description = "Updated short biography", example = "Desenvolvedor Full Stack especializado em arquitetura de microsserviços")
    private String miniBio;
    
    @Schema(description = "Updated list of expertise areas", example = "[\"Java\", \"Kubernetes\", \"Cloud\"]")
    private List<String> areas;
    
    @Schema(description = "Updated scheduling link", example = "https://calendly.com/updated-mentor")
    private String schedulingLink;
}
