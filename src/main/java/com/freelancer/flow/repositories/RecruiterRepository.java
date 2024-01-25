package com.freelancer.flow.repositories;

import com.freelancer.flow.entities.RecruiterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruiterRepository extends JpaRepository<RecruiterEntity, Long> {

}
