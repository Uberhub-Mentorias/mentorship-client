package com.mentorship.profile.dto.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProfileRequest {

  private String miniBio;

  private List<String> areas;

  private String schedulingLink;

  private String photoUrl;
}
