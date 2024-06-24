package com.freelancer.flow.specifications;

import com.freelancer.flow.entities.ContractEntity;
import com.freelancer.flow.entities.ProjectEntity;
import org.springframework.data.jpa.domain.Specification;

public class ContractSpecification {
    public static Specification<ContractEntity> withContractId(String contractId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("createdBy"), contractId);
    }
}
