package com.freelancer.flow.specifications;

import com.freelancer.flow.entities.ClientEntity;
import com.freelancer.flow.entities.ProjectEntity;
import org.springframework.data.jpa.domain.Specification;

public class ProjectSpecification {
    public static Specification<ProjectEntity> withProjectId(String projectId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("createdBy"), projectId);
    }
}
