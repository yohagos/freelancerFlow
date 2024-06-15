package com.freelancer.flow.specifications;

import com.freelancer.flow.entities.RecruiterEntity;
import org.springframework.data.jpa.domain.Specification;

public class RecruiterSpecification {

    public static Specification<RecruiterEntity> withOwnerId(String ownerId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("createdBy"), ownerId);
    }
}
