package com.iftm.mentorship_client.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminLogsDTO {
    private String id;

    @NotBlank(message="O campo 'type' não pode estar vazio")
    private String type;

    @NotBlank(message="O campo 'author' não pode estar vazio")
    private String author;

    private LocalDateTime registeredAt;
}