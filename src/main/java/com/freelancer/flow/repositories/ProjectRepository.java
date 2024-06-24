package com.freelancer.flow.repositories;

import com.freelancer.flow.entities.ProjectEntity;
import com.freelancer.flow.specifications.ProjectSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer>, JpaSpecificationExecutor<ProjectSpecification> {
    @Query("""
            SELECT project
            FROM ProjectEntity project
            """)
    Page<ProjectEntity> findAllDisplayableProjects(Pageable pageable);
}
