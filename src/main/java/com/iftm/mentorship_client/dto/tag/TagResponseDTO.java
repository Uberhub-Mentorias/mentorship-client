package com.iftm.mentorship_client.dto.tag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagResponseDTO {

  private String id;

  private String name;

  private String category;

  private String description;

  private Instant createdAt;

  private Instant updatedAt;
}
