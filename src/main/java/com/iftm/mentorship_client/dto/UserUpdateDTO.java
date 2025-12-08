package com.iftm.mentorship_client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "User update payload")
public class UserUpdateDTO {
    
    @Schema(description = "Full name", example = "João Silva")
    private String name;
    
    @Email(message = "Formato de e-mail inválido")
    @Schema(description = "Email", example = "user@example.com")
    private String email;
    
    @Schema(description = "Phone number", example = "+5511999999999")
    private String telefone;
    
    @Schema(description = "Company name", example = "ACME")
    private String empresa;
}
