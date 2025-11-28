package com.iftm.mentorship_client.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO {
    
    private String name;
    
    @Email(message = "Formato de e-mail inválido")
    private String email;
    
    private String telefone;
    
    private String empresa;
}
