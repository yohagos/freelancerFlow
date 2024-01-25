package com.freelancer.flow.services;

import com.freelancer.flow.entities.RecruiterEntity;
import com.freelancer.flow.repositories.RecruiterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecruiterService {

    private final RecruiterRepository recruiterRepository;

    public List<RecruiterEntity> getRecruiters() {
        return recruiterRepository.findAll();
    }
}
