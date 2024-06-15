package com.freelancer.flow.repositories;

import com.freelancer.flow.entities.ContractEntity;
import com.freelancer.flow.specifications.ContractSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Integer>, JpaSpecificationExecutor<ContractSpecification> {
    @Query("""
            SELECT contract
            FROM ContractEntity contract
            """)
    Page<ContractEntity> findAllDisplayableContracts(Pageable pageable);
}
