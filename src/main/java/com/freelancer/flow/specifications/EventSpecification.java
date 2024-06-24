package com.freelancer.flow.specifications;

import com.freelancer.flow.entities.EventEntity;
import org.springframework.data.jpa.domain.Specification;

public class EventSpecification {
    public static Specification<EventEntity> withEventId(String eventId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("createdBy"), eventId);
    }
}
