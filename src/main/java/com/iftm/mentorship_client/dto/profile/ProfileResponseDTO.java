package com.mentorship.profile.dto.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponseDTO {

  private String id;
  private String mentorId;
  private String miniBio;
  private List<String> areas;
  private String schedulingLink;
  private String status;

  private Instant createdAt;
  private Instant updatedAt;
  private Instant approvedAt;

  private String approvedBy;
}
