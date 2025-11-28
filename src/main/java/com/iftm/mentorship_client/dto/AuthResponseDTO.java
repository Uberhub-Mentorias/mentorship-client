package com.iftm.mentorship_client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDTO {
    
    private String accessToken;
        
    @Builder.Default
    private String tokenType = "Bearer";
    
    private Long expiresIn;
    
    private UserResponseDTO user;
    

    public static AuthResponseDTO create(String access, Long expires, UserResponseDTO userDto) {
        return AuthResponseDTO.builder()
                .accessToken(access)
                .expiresIn(expires)
                .user(userDto)
                .build();
    }
}
