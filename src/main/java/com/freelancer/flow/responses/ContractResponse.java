package com.freelancer.flow.responses;

import com.freelancer.flow.entities.ProjectEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractResponse {
    private Integer id;
    private ProjectEntity project;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double remoteRate;
    private Double onSiteRate;
}
