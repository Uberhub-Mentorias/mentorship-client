package com.iftm.mentorship_client.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDTO {

    private String id;
    private long totalMentorships;
    private long totalUsers;
    private long totalMentors;

    private long totalVouchers;
    private long totalActiveVouchers;
    private LocalDateTime createdAt;
}
