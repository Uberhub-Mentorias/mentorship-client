package com.iftm.mentorship_client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Authentication response containing access token and user info")
public class AuthResponseDTO {
    
    @Schema(description = "JWT access token", example = "eyJhbGciOiJI...")
    private String accessToken;
    
    @Builder.Default
    @Schema(description = "Token type", example = "Bearer")
    private String tokenType = "Bearer";
    
    @Schema(description = "Expiration time in milliseconds", example = "86400000")
    private Long expiresIn;
    
    @Schema(description = "Authenticated user details")
    private UserResponseDTO user;

    public static AuthResponseDTO create(String access, Long expires, UserResponseDTO userDto) {
        return AuthResponseDTO.builder()
                .accessToken(access)
                .expiresIn(expires)
                .user(userDto)
                .build();
    }
}
