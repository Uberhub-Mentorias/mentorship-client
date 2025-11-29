package com.mentorship.profile.mapper;

import com.mentorship.profile.document.TagDocument;
import com.mentorship.profile.dto.tag.TagResponseDTO;

public class TagMapper {

  // Convert Document -> DTO
  public static TagResponseDTO toDTO(TagDocument tag) {
    if (tag == null)
      return null;

    TagResponseDTO dto = new TagResponseDTO();
    dto.setId(tag.getId());
    dto.setName(tag.getName());
    dto.setCategory(tag.getCategory());
    dto.setDescription(tag.getDescription());
    dto.setCreatedAt(tag.getCreatedAt());
    dto.setUpdatedAt(tag.getUpdatedAt());

    return dto;
  }

  // Convert Request -> Document (Create)
  public static TagDocument fromRequest(TagDocument req) {
    return TagDocument.builder()
        .name(req.getName())
        .category(req.getCategory())
        .description(req.getDescription())
        .build();
  }

  // Apply updates
  public static void applyUpdates(TagDocument tag, TagDocument req) {
    if (req.getName() != null)
      tag.setName(req.getName());
    if (req.getCategory() != null)
      tag.setCategory(req.getCategory());
    if (req.getDescription() != null)
      tag.setDescription(req.getDescription());
  }
}
