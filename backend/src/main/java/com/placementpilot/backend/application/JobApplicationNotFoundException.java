package com.placementpilot.backend.application;

public class JobApplicationNotFoundException extends RuntimeException {

    public JobApplicationNotFoundException(Long id) {
        super("Application with id " + id + " was not found.");
    }
}
