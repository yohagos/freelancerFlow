package com.freelancer.flow.specifications;

import com.freelancer.flow.entities.ClientEntity;
import com.freelancer.flow.entities.RecruiterEntity;
import org.springframework.data.jpa.domain.Specification;

public class ClientSpecification {

    public static Specification<ClientEntity> withClientId(String clientId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("createdBy"), clientId);
    }
}
