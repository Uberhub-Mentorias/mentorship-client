package com.mentorship.profile.document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileDocument {

    @Id
    private String id;

    @Field("mentorId")
    private String mentorId;

    @Field("miniBio")
    private String miniBio;

    @Field("areas")
    @Builder.Default
    private List<String> areas = new ArrayList<>();

    @Field("schedulingLink")
    private String schedulingLink;

    @Field("status")
    @Builder.Default
    private ProfileStatus status = ProfileStatus.PENDING;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    private Instant approvedAt;
    private String approvedBy;
}
