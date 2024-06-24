package com.freelancer.flow.repositories;

import com.freelancer.flow.entities.EventEntity;
import com.freelancer.flow.specifications.EventSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer>, JpaSpecificationExecutor<EventSpecification> {
    @Query("""
            SELECT event
            FROM EventEntity event
            """)
    Page<EventEntity> findAllDisplayableEvents(Pageable pageable);
}
