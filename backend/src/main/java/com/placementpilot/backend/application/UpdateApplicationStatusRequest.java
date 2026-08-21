package com.placementpilot.backend.application;

import jakarta.validation.constraints.NotNull;

public record UpdateApplicationStatusRequest(@NotNull ApplicationStatus status) {
}
