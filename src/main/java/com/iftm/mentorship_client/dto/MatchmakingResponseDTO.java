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
@Schema(description = "Response object containing the matched mentor information")
public class MatchmakingResponseDTO {
    
    @Schema(
            description = "The ID of the matched mentor",
            example = "507f1f77bcf86cd799439011"
    )
    private String mentorId;
    
    @Schema(
            description = "The name of the matched mentor",
            example = "João Silva"
    )
    private String mentorName;
    
    @Schema(
            description = "The company where the mentor works",
            example = "Tech Corp"
    )
    private String mentorCompany;
    
    @Schema(
            description = "The job title of the matched mentor",
            example = "Senior Software Engineer"
    )
    private String mentorJobTitle;
    
    @Schema(
            description = "The match score indicating how well the mentor matches the requested tags",
            example = "85"
    )
    private Integer matchScore;
    
    @Schema(
            description = "Message describing the result of the matchmaking operation",
            example = "Successfully matched with mentor"
    )
    private String message;
}
