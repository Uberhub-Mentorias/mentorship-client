package com.iftm.mentorship_client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Password change payload")
public class PasswordChangeDTO {
    
    @NotBlank(message = "A senha atual é obrigatória")
    @Schema(description = "Current password", requiredMode = Schema.RequiredMode.REQUIRED)
    private String currentPassword;
    
    @NotBlank(message = "A nova senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    @Schema(description = "New password", requiredMode = Schema.RequiredMode.REQUIRED)
    private String newPassword;
}
