package com.iftm.mentorship_client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "User registration payload")
public class UserRegistrationDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Schema(description = "Full name", example = "João Silva", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    @Schema(description = "Email address", example = "user@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    @Schema(description = "Password", example = "P@ssw0rd", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    @Schema(description = "Phone number", example = "+5511999999999")
    private String telefone;
    
    @Schema(description = "Company name", example = "ACME")
    private String empresa;
}
