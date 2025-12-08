package com.iftm.mentorship_client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Refresh token request")
public class RefreshTokenRequestDTO {
    
    @NotBlank(message = "Token é obrigatório")
    @Schema(description = "Refresh token", example = "refresh-token-xyz", requiredMode = Schema.RequiredMode.REQUIRED)
    private String token;
}
