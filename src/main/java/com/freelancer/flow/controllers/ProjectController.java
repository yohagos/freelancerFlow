package com.freelancer.flow.controllers;

import com.freelancer.flow.common.PageResponse;
import com.freelancer.flow.requests.ProjectRequest;
import com.freelancer.flow.responses.ProjectResponse;
import com.freelancer.flow.services.ProjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("projects")
@RequiredArgsConstructor
@Tag(name = "Projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<PageResponse<ProjectResponse>> getProjects(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size
    ) {
        return ResponseEntity.ok(projectService.getProjects(page, size));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectResponse> getProject(
            @PathVariable("projectId") Integer projectId
    ) {
        return ResponseEntity.ok(projectService.getProject(projectId));
    }

    @PostMapping
    public ResponseEntity<Integer> saveProject(
            @Valid @RequestBody ProjectRequest request
    ) {
        return ResponseEntity.ok(projectService.save(request));
    }

    @PatchMapping
    public ResponseEntity<ProjectResponse> updateProject(
            @Valid @RequestBody ProjectRequest request
    ) {
        return ResponseEntity.ok(projectService.update(request));
    }

    @DeleteMapping("/remove/{projectId}")
    public ResponseEntity<?> deleteProject(
            @PathVariable("projectId") Integer projectId
    ) {
        projectService.delete(projectId);
        return ResponseEntity.accepted().build();
    }
}
