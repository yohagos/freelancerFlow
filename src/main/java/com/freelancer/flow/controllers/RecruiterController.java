package com.freelancer.flow.controllers;

import com.freelancer.flow.entities.RecruiterEntity;
import com.freelancer.flow.repositories.RecruiterRepository;
import com.freelancer.flow.services.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/recruiter")
@RequiredArgsConstructor
public class RecruiterController {

    private final RecruiterService recruiterService;

    @GetMapping
    public ResponseEntity<List<RecruiterEntity>> getRecruiters() {
        return ResponseEntity.ok(recruiterService.getRecruiters());
    }
}
