package com.freelancer.flow.controllers;

import com.freelancer.flow.common.PageResponse;
import com.freelancer.flow.requests.RecruiterRequest;
import com.freelancer.flow.responses.RecruiterResponse;
import com.freelancer.flow.services.RecruiterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("recruiters")
@RequiredArgsConstructor
@Tag(name = "Recruiter")
public class RecruiterController {

    private final RecruiterService recruiterService;

    @GetMapping
    public ResponseEntity<PageResponse<RecruiterResponse>> getRecruiters(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(recruiterService.getRecruiters(page, size, connectedUser));
    }

    @GetMapping("/{recruiterId}")
    public ResponseEntity<RecruiterResponse> getRecruiter(
            @PathVariable("recruiterId") Integer recruiterId
    ) {
        return ResponseEntity.ok(recruiterService.getRecruiter(recruiterId));
    }

    @PostMapping
    public ResponseEntity<Integer> saveRecruiter(
            @Valid @RequestBody RecruiterRequest request
    ) {
        return ResponseEntity.ok(recruiterService.save(request));
    }

    @PatchMapping
    public ResponseEntity<RecruiterResponse> updateRecruiter(
            @Valid @RequestBody RecruiterRequest request
    ) {
        return ResponseEntity.ok(recruiterService.update(request));
    }

    @DeleteMapping("/remove/{recruiterId}")
    public ResponseEntity<?> deleteRecruiterById(
            @PathVariable("recruiterId") Integer recruiterId
    ) {
        log.warn(recruiterId.toString());
        recruiterService.deleteRecruiter(recruiterId);
        return ResponseEntity.accepted().build();
    }
}
