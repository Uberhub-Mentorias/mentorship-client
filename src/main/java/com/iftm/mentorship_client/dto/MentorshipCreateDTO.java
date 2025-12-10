package com.iftm.mentorship_client.dto;

import com.iftm.mentorship_client.model.enums.MentorshipStatus;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorshipCreateDTO {
        
    @NotNull(message = "tags é obrigatório")
    @NotEmpty(message = "tags não pode estar vazio")
    private List<String> tags;

}

