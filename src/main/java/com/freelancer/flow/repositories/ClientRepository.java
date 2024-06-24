package com.freelancer.flow.repositories;

import com.freelancer.flow.entities.ClientEntity;
import com.freelancer.flow.specifications.ClientSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer>, JpaSpecificationExecutor<ClientSpecification> {

    @Query("""
            SELECT client
            FROM ClientEntity client
            """)
    Page<ClientEntity> findAllDisplayableClients(Pageable pageable);
}
