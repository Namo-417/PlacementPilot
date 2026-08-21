package com.placementpilot.backend.application;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public List<JobApplicationResponse> findAll(String query, ApplicationStatus status) {
        String normalizedQuery = query == null ? "" : query.trim().toLowerCase(Locale.ROOT);

        return repository.findAll().stream()
                .filter(application -> status == null || application.getStatus() == status)
                .filter(application -> normalizedQuery.isEmpty()
                        || application.getCompanyName().toLowerCase(Locale.ROOT).contains(normalizedQuery)
                        || application.getPosition().toLowerCase(Locale.ROOT).contains(normalizedQuery))
                .sorted(Comparator.comparing(JobApplication::getApplicationDate).reversed())
                .map(JobApplicationResponse::from)
                .toList();
    }

    public JobApplicationResponse findById(Long id) {
        return JobApplicationResponse.from(getEntity(id));
    }

    public JobApplicationResponse create(JobApplicationRequest request) {
        JobApplication application = new JobApplication();
        applyRequest(application, request);
        return JobApplicationResponse.from(repository.save(application));
    }

    public JobApplicationResponse update(Long id, JobApplicationRequest request) {
        JobApplication application = getEntity(id);
        applyRequest(application, request);
        return JobApplicationResponse.from(repository.save(application));
    }

    public JobApplicationResponse updateStatus(Long id, ApplicationStatus status) {
        JobApplication application = getEntity(id);
        application.setStatus(status);
        return JobApplicationResponse.from(repository.save(application));
    }

    public void delete(Long id) {
        repository.delete(getEntity(id));
    }

    private JobApplication getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new JobApplicationNotFoundException(id));
    }

    private void applyRequest(JobApplication application, JobApplicationRequest request) {
        application.setCompanyName(request.companyName().trim());
        application.setPosition(request.position().trim());
        application.setLocation(request.location().trim());
        application.setJobType(request.jobType());
        application.setStatus(request.status());
        application.setApplicationDate(request.applicationDate());
        application.setDeadline(request.deadline());
        application.setJobLink(request.jobLink());
        application.setNotes(request.notes());
    }
}
