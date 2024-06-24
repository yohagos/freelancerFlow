package com.freelancer.flow.responses;

import com.freelancer.flow.entities.ClientEntity;
import com.freelancer.flow.entities.RecruiterEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponse {
    private Integer id;
    private ClientEntity client;
    private RecruiterEntity recruiter;
    private String projectName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
