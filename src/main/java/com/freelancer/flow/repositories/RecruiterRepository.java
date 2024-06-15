package com.freelancer.flow.repositories;

import com.freelancer.flow.entities.RecruiterEntity;
import com.freelancer.flow.specifications.RecruiterSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruiterRepository extends JpaRepository<RecruiterEntity, Integer>, JpaSpecificationExecutor<RecruiterSpecification> {

    @Query("""
            SELECT rec
            FROM RecruiterEntity rec
            WHERE rec.createdBy = :userId
            """)
    Page<RecruiterEntity> findAllDisplayableRecruiters(Pageable pageable, String userId);

}
