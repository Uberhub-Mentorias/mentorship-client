package com.iftm.mentorship_client.dto;

import com.iftm.mentorship_client.model.enums.MentorshipStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorshipUpdateDTO {
    
    private String menteeId;
    
    private String mentorId;
    
    private MentorshipStatus status;
    
    @NotEmpty(message = "tags não pode estar vazio se fornecido")
    private List<String> tags;
    
    private String scheduledSessionId;
    
    private String notes;
    
    private Double matchingScore;
}

