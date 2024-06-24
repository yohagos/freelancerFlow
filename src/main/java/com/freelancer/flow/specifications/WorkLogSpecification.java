package com.freelancer.flow.specifications;

import com.freelancer.flow.entities.WorkLogEntity;
import org.springframework.data.jpa.domain.Specification;

public class WorkLogSpecification {

    public static Specification<WorkLogEntity> withProjectId(String projectId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("project.id"), projectId);
    }
}
