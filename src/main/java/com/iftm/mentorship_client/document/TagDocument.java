package com.iftm.mentorship_client.document;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "tags")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagDocument {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("category")
    private String category;

    @Field("description")
    private String description;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}
