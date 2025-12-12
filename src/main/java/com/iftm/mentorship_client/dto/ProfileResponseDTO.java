package com.iftm.mentorship_client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import com.iftm.mentorship_client.model.enums.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponseDTO {

  private String id;
  private String userId;

  private String name;
  private String email;
  private String telefone;
  private Set<Role> roles;

  private String miniBio;
  private List<String> areas;
  private String schedulingLink;
  private String empresa;
  private String jobTitle;
  private String status;

  private Instant createdAt;
  private Instant updatedAt;
  private Instant approvedAt;

  private String approvedBy;
}
