package com.iftm.mentorship_client.dto;

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

  private String company;

  private String jobTitle;
}
