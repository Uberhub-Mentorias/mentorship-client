package com.iftm.mentorship_client.dto;


import com.iftm.mentorship_client.model.enums.Role;
import com.iftm.mentorship_client.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private String id;
    private String name;
    private String email;
    private String telefone;
    private String empresa;
    private Set<Role> roles; 
    private Status status;
    private Integer voucherCreditBalance; 


}