package com.iftm.mentorship_client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FcmTokenDTO {
    private String id;
    private String userId;
    private String token;
    private String deviceId;
    private Instant createdAt;
    private Instant lastUsedAt;
}