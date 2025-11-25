package com.iftm.mentorship_client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import com.iftm.mentorship_client.model.enums.MentorshipStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorshipResponseDTO {
    
    private String id;
    
    private String menteeId;
    
    private String mentorId;
    
    private MentorshipStatus status;
    
    private List<String> tags;
    
    private String scheduledSessionId;
    
    private String notes;
    
    private Double matchingScore;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}

