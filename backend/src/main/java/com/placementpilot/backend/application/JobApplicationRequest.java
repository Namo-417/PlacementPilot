package com.placementpilot.backend.application;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record JobApplicationRequest(
        @NotBlank @Size(max = 120) String companyName,
        @NotBlank @Size(max = 120) String position,
        @NotBlank @Size(max = 120) String location,
        @NotNull JobType jobType,
        @NotNull ApplicationStatus status,
        @NotNull LocalDate applicationDate,
        LocalDate deadline,
        @Size(max = 500) String jobLink,
        @Size(max = 2000) String notes
) {
}
