package com.placementpilot.backend.application;

import java.time.LocalDate;

public record JobApplicationResponse(
        Long id,
        String companyName,
        String position,
        String location,
        JobType jobType,
        ApplicationStatus status,
        LocalDate applicationDate,
        LocalDate deadline,
        String jobLink,
        String notes
) {
    static JobApplicationResponse from(JobApplication application) {
        return new JobApplicationResponse(
                application.getId(),
                application.getCompanyName(),
                application.getPosition(),
                application.getLocation(),
                application.getJobType(),
                application.getStatus(),
                application.getApplicationDate(),
                application.getDeadline(),
                application.getJobLink(),
                application.getNotes()
        );
    }
}
