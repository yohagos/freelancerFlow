package com.freelancer.flow.responses;

import com.freelancer.flow.entities.ProjectEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkLogResponse {
    private Integer id;
    private ProjectEntity project;
    private LocalDateTime workDate;
    private Double hoursWorked;
    private Boolean isRemote;
    private String notice;
}
