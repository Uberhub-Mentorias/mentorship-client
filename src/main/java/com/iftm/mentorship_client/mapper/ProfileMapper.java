package com.mentorship.profile.mapper;

import com.mentorship.profile.document.ProfileDocument;
import com.mentorship.profile.document.ProfileStatus;
import com.mentorship.profile.dto.profile.CreateProfileRequest;
import com.mentorship.profile.dto.profile.ProfileResponseDTO;
import com.mentorship.profile.dto.profile.UpdateProfileRequest;

public class ProfileMapper {

  // Convert Document -> DTO
  public static ProfileResponseDTO toDTO(ProfileDocument doc) {
    if (doc == null)
      return null;

    ProfileResponseDTO dto = new ProfileResponseDTO();
    dto.setId(doc.getId());
    dto.setMentorId(doc.getMentorId());
    dto.setMiniBio(doc.getMiniBio());
    dto.setAreas(doc.getAreas());
    dto.setSchedulingLink(doc.getSchedulingLink());
    dto.setStatus(doc.getStatus().name());
    dto.setApprovedAt(doc.getApprovedAt());
    dto.setApprovedBy(doc.getApprovedBy());
    dto.setCreatedAt(doc.getCreatedAt());
    dto.setUpdatedAt(doc.getUpdatedAt());

    return dto;
  }

  // Convert CreateRequest -> Document
  public static ProfileDocument fromCreateRequest(String mentorId, CreateProfileRequest req) {
    return ProfileDocument.builder()
        .mentorId(mentorId)
        .miniBio(req.getMiniBio())
        .areas(req.getAreas())
        .schedulingLink(req.getSchedulingLink())
        .status(ProfileStatus.PENDING)
        .build();
  }

  // Apply UpdateRequest to existing document
  public static void applyUpdates(ProfileDocument doc, UpdateProfileRequest req) {
    if (req.getMiniBio() != null)
      doc.setMiniBio(req.getMiniBio());
    if (req.getAreas() != null)
      doc.setAreas(req.getAreas());
    if (req.getSchedulingLink() != null)
      doc.setSchedulingLink(req.getSchedulingLink());
  }
}
