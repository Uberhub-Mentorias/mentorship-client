package com.iftm.mentorship_client.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDTO {
    private String id;

    @NotBlank(message = "Necessário informar o nome da tag.")
    private String name;

    @NotBlank(message = "Necessário estar incluído em uma categoria.")
    private TagCategoryDTO category;
}
