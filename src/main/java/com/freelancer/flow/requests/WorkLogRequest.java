package com.freelancer.flow.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class WorkLogRequest {
    private Integer id;
    @NotNull(message = "Project ID cannot be Null")
    @NotBlank(message = "Project ID cannot be Blank")
    private Integer projectId;
    private LocalDateTime workDate;
    private Double hoursWorked;
    private Boolean isRemote;
    private String notice;
}
