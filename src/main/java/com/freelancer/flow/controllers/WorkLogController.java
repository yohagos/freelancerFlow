package com.freelancer.flow.controllers;

import com.freelancer.flow.common.PageResponse;
import com.freelancer.flow.entities.WorkLogEntity;
import com.freelancer.flow.requests.WorkLogRequest;
import com.freelancer.flow.responses.WorkLogResponse;
import com.freelancer.flow.services.WorkLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("logs")
@RequiredArgsConstructor
@Tag(name = "Work Log")
public class WorkLogController {

    private final WorkLogService workLogService;

    @GetMapping
    public ResponseEntity<List<WorkLogResponse>> getWorkLogs() {
        return ResponseEntity.ok(workLogService.getWorkLogs());
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<PageResponse<WorkLogResponse>> getWorkLogsByProjectId(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @PathVariable("projectId") Integer projectId
    ) {
        return ResponseEntity.ok(workLogService.getWorkLogsByProjectId(page, size, projectId));
    }

    @GetMapping("/{logId}")
    public ResponseEntity<WorkLogResponse> getWorkLog(
            @PathVariable("logId") Integer logId
    ) {
        return ResponseEntity.ok(workLogService.getWorkLog(logId));
    }

    @PostMapping
    public ResponseEntity<Integer> saveWorkLog(
            @Valid @RequestBody WorkLogRequest request
    ) {
        return ResponseEntity.ok(workLogService.save(request));
    }
}
