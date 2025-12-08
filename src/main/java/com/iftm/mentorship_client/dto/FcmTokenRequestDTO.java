package com.iftm.mentorship_client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "FCM token request payload")
public class FcmTokenRequestDTO {
    
    @NotBlank(message = "O token FCM é obrigatório")
    @Schema(description = "FCM token", example = "fcm_token_xyz", requiredMode = Schema.RequiredMode.REQUIRED)
    private String token;
    
    @Schema(description = "Device identifier")
    private String deviceId;
}
