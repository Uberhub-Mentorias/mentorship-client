package com.iftm.mentorship_client.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagCategoryDTO {
    private String id;

    @NotBlank(message = "Necessário informar o nome da categoria.")
    private String name;
}
