package com.mentorship.admin.models.dto;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminLogsDTO {
    private ObjectId id;

    @NotBlank(message="O campo 'type' não pode estar vazio")
    private String type;

    @NotBlank(message="O campo 'author' não pode estar vazio")
    private String author;

    private LocalDateTime registeredAt;
}