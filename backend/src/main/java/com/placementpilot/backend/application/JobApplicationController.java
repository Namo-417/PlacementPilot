package com.placementpilot.backend.application;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/applications")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @GetMapping
    public List<JobApplicationResponse> findAll(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) ApplicationStatus status
    ) {
        return service.findAll(query, status);
    }

    @GetMapping("/{id}")
    public JobApplicationResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<JobApplicationResponse> create(@Valid @RequestBody JobApplicationRequest request) {
        JobApplicationResponse created = service.create(request);
        return ResponseEntity.created(URI.create("/api/v1/applications/" + created.id())).body(created);
    }

    @PutMapping("/{id}")
    public JobApplicationResponse update(@PathVariable Long id, @Valid @RequestBody JobApplicationRequest request) {
        return service.update(id, request);
    }

    @PatchMapping("/{id}/status")
    public JobApplicationResponse updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody UpdateApplicationStatusRequest request
    ) {
        return service.updateStatus(id, request.status());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
