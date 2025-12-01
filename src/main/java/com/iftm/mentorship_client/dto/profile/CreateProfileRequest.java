package com.iftm.mentorship_client.dto.profile;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProfileRequest {

  @NotBlank
  private String miniBio;

  private List<String> areas;

  private String schedulingLink;

  private String photoUrl;
}