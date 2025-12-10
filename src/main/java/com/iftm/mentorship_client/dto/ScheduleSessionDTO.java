package com.iftm.mentorship_client.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleSessionDTO {
    
    @NotNull(message = "Data/hora do agendamento é obrigatória")
    @Future(message = "Data/hora deve ser futura")
    private LocalDateTime scheduledAt;
    
    private String meetingLink;
    
    private String notes;
}
