package com.freelancer.flow.services;

import com.freelancer.flow.common.PageResponse;
import com.freelancer.flow.entities.ProjectEntity;
import com.freelancer.flow.mappers.ProjectMapper;
import com.freelancer.flow.repositories.ProjectRepository;
import com.freelancer.flow.requests.ProjectRequest;
import com.freelancer.flow.responses.ProjectResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.freelancer.flow.enums.CategoryEnum.PROJECT;
import static com.freelancer.flow.enums.EventEnum.*;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final EventService eventService;

    public PageResponse<ProjectResponse> getProjects(
            int page,
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<ProjectEntity> projects = projectRepository
                .findAllDisplayableProjects(pageable);
        List<ProjectResponse> projectResponses = projects
                .stream()
                .map(projectMapper::toProjectResponse)
                .toList();
        return new PageResponse<>(
                projectResponses,
                projects.getNumber(),
                projects.getSize(),
                projects.getTotalElements(),
                projects.getTotalPages(),
                projects.isFirst(),
                projects.isLast()
        );
    }

    public ProjectResponse getProject(Integer projectId) {
        return projectRepository.findById(projectId)
                .map(projectMapper::toProjectResponse)
                .orElseThrow(() -> new EntityNotFoundException("Contract with ID "+ projectId + "cannot be found"));
    }

    public Integer save(ProjectRequest request) {
        var pro = projectMapper.toProject(request);
        var project = projectRepository.save(pro);

        eventService.createEventEntry(
                PROJECT,
                ADD,
                project,
                null,
                null,
                null,
                null
        );

        return project.getId();
    }

    public ProjectResponse update(ProjectRequest request) {
        var project = projectRepository
                .findById(request.getId())
                .orElseThrow();

        Optional.of(request.getProjectName())
                .filter(name -> !name.equals(project.getProjectName()))
                .ifPresent(project::setProjectName);
        Optional.of(request.getStartDate())
                .filter(date -> !date.equals(project.getStartDate()))
                .ifPresent(project::setStartDate);
        Optional.of(request.getEndDate())
                .filter(date -> !date.equals(project.getEndDate()))
                .ifPresent(project::setEndDate);
        projectRepository.save(project);

        eventService.createEventEntry(
                PROJECT,
                EDIT,
                project,
                null,
                null,
                null,
                null
        );

        return projectMapper.toProjectResponse(project);
    }

    public void delete(Integer projectId) {
        var project = projectRepository
                .findById(projectId)
                        .orElseThrow();
        eventService.createEventEntry(
                PROJECT,
                DELETE,
                project,
                null,
                null,
                null,
                null
        );
        projectRepository.deleteById(projectId);
    }
}
