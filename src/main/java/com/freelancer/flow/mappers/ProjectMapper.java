package com.freelancer.flow.mappers;

import com.freelancer.flow.entities.ClientEntity;
import com.freelancer.flow.entities.ProjectEntity;
import com.freelancer.flow.entities.RecruiterEntity;
import com.freelancer.flow.requests.ProjectRequest;
import com.freelancer.flow.responses.ProjectResponse;
import org.springframework.stereotype.Service;

@Service
public class ProjectMapper {

    public ProjectEntity toProject(
            ProjectRequest request
    ) {
        var project = ProjectEntity.builder()
                .id(request.getId())
                .client(
                        ClientEntity.builder()
                                .id(request.getClientId())
                                .build()
                )
                .projectName(request.getProjectName())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();
        if (request.getRecruiterId() != null) {
            project.setRecruiter(
                    RecruiterEntity.builder()
                            .id(request.getRecruiterId())
                            .build()
            );
        }
        return project;
    }

    public ProjectResponse toProjectResponse(
            ProjectEntity entity
    ) {
        return ProjectResponse.builder()
                .id(entity.getId())
                .recruiter(entity.getRecruiter())
                .client(entity.getClient())
                .projectName(entity.getProjectName())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .build();
    }
}
