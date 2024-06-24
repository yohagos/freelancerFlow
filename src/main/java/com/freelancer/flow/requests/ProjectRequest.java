package com.freelancer.flow.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ProjectRequest {
    private Integer id;
    @NotNull(message = "Client ID cannot be null")
    @NotBlank(message = "Client ID cannot be blank")
    private Integer clientId;
    private Integer recruiterId;
    @NotNull(message = "Project name cannot be null")
    @NotBlank(message = "Project name cannot be blank")
    private String projectName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
