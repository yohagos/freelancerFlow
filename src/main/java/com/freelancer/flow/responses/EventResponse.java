package com.freelancer.flow.responses;

import com.freelancer.flow.entities.*;
import jakarta.annotation.Nullable;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
    private Integer id;
    private String category;
    private String event;
    private Integer categoryId;
    private String phone;
    private String website;

    private String companyName;
    private String name;
    private String email;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private String projectName;
    private String recruiterName;

    private Double remoteRate;
    private Double onSiteRate;
    private LocalDateTime workDate;
    private Double hoursWorked;
    private Boolean isRemote;

}
