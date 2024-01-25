package com.freelancer.flow.controllers;

import com.freelancer.flow.entities.WorkLogEntity;
import com.freelancer.flow.services.WorkLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/workLogs")
@RequiredArgsConstructor
public class WorkLogController {

    private final WorkLogService workLogService;

    @GetMapping
    public ResponseEntity<List<WorkLogEntity>> getWorkLogs() {
        return ResponseEntity.ok(workLogService.getWorkLogs());
    }
}
