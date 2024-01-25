package com.freelancer.flow.repositories;

import com.freelancer.flow.entities.WorkLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkLogRepository extends JpaRepository<WorkLogEntity, Long> {
}
