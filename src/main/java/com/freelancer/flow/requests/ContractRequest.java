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
public class ContractRequest {
    private Integer id;
    @NotNull(message = "201")
    private Integer projectId;
    @NotNull(message = "Start date cannot be null")
    @NotBlank(message = "Start date cannot be blank")
    private LocalDateTime startDate;
    @NotNull(message = "End date cannot be null")
    @NotBlank(message = "End date cannot be blank")
    private LocalDateTime endDate;
    private Double remoteRate;
    private Double onSiteRate;
}
