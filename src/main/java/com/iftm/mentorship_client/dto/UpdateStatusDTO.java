package com.iftm.mentorship_client.dto;

import com.iftm.mentorship_client.model.enums.MentorshipStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStatusDTO {
    
    @NotNull(message = "Status é obrigatório")
    private MentorshipStatus status;
    
    private String notes;
}
