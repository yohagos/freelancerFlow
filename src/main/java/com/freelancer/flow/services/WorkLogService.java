package com.freelancer.flow.services;

import com.freelancer.flow.common.PageResponse;
import com.freelancer.flow.entities.WorkLogEntity;
import com.freelancer.flow.mappers.WorkLogMapper;
import com.freelancer.flow.repositories.WorkLogRepository;
import com.freelancer.flow.requests.WorkLogRequest;
import com.freelancer.flow.responses.WorkLogResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.freelancer.flow.enums.CategoryEnum.WORK_LOG;
import static com.freelancer.flow.enums.EventEnum.ADD;


@Service
@RequiredArgsConstructor
public class WorkLogService {

    private final WorkLogRepository workLogRepository;
    private final WorkLogMapper workLogMapper;
    private final EventService eventService;
    private final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    public List<WorkLogResponse> getWorkLogs() {
        return workLogRepository.findAll()
                .stream()
                .map(workLogMapper::toWorkLogResponse)
                .toList();
    }

    public WorkLogResponse getWorkLog(Integer logId) {
        return workLogRepository.findById(logId)
                .map(workLogMapper::toWorkLogResponse)
                .orElseThrow(() -> new EntityNotFoundException("Contract with ID "+ logId + "cannot be found"));
    }

    public Integer save(WorkLogRequest request) {
        var workLog = workLogRepository.save(workLogMapper.toWorkLog(request));
        eventService.createEventEntry(
                auth,
                WORK_LOG,
                ADD,
                null,
                null,
                null,
                null,
                workLog
        );
        return workLog.getId();
    }

    public PageResponse<WorkLogResponse> getWorkLogsByProjectId(int page, int size, Integer projectId) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<WorkLogEntity> logs = workLogRepository
                .findWorkLogByProjectId(pageable, projectId);

        List<WorkLogResponse> logResponses = logs
                .stream()
                .map(workLogMapper::toWorkLogResponse)
                .toList();
        return new PageResponse<>(
                logResponses,
                logs.getNumber(),
                logs.getSize(),
                logs.getTotalElements(),
                logs.getTotalPages(),
                logs.isFirst(),
                logs.isLast()
        );
    }
}
