package com.iftm.mentorship_client.dto;

import com.iftm.mentorship_client.model.enums.Role;
import com.iftm.mentorship_client.model.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "User response DTO")
public class UserResponseDTO {
    
    @Schema(description = "User id", example = "64a1f3d8...")
    private String id;
    
    @Schema(description = "User full name", example = "João Silva")
    private String name;
    
    @Schema(description = "User email", example = "user@example.com")
    private String email;
    
    @Schema(description = "Phone number", example = "+5511999999999")
    private String telefone;
    
    @Schema(description = "Company name", example = "ACME")
    private String empresa;
    
    @Schema(description = "User roles")
    private Set<Role> roles;
    
    @Schema(description = "Account status")
    private Status status;
    
    @Schema(description = "Voucher credit balance")
    private Integer voucherCreditBalance;
}
