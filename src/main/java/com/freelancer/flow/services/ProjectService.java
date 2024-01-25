package com.freelancer.flow.services;

import com.freelancer.flow.entities.ProjectEntity;
import com.freelancer.flow.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<ProjectEntity> getProjects() {
        return projectRepository.findAll();
    }
}
