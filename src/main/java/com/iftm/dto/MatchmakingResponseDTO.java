package com.iftm.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response object containing the matched mentor information")
public class MatchmakingResponseDTO {
    
    @Schema(
            description = "The ID of the matched mentor",
            example = "507f1f77bcf86cd799439011"
    )
    private String mentorId;
    
    @Schema(
            description = "Message describing the result of the matchmaking operation",
            example = "Successfully matched with mentor"
    )
    private String message;
}
