package com.iftm.mentorship_client.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FcmTokenRequestDTO {
    
    @NotBlank(message = "O token FCM é obrigatório")
    private String token;
    
    private String deviceId; // Opcional, para controle de múltiplos dispositivos
}