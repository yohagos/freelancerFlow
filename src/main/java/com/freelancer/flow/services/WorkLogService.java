package com.freelancer.flow.services;

import com.freelancer.flow.entities.WorkLogEntity;
import com.freelancer.flow.repositories.WorkLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkLogService {

    private final WorkLogRepository workLogRepository;


    public List<WorkLogEntity> getWorkLogs() {
        return workLogRepository.findAll();
    }
}
