package com.freelancer.flow.repositories;

import com.freelancer.flow.entities.WorkLogEntity;
import com.freelancer.flow.responses.WorkLogResponse;
import com.freelancer.flow.specifications.WorkLogSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkLogRepository extends JpaRepository<WorkLogEntity, Integer>, JpaSpecificationExecutor<WorkLogSpecification> {

    @Query("""
            SELECT log
            FROM WorkLogEntity log
            WHERE log.project.id = :projectId
            """)
    Page<WorkLogEntity> findWorkLogByProjectId(Pageable pageable, Integer projectId);
}
