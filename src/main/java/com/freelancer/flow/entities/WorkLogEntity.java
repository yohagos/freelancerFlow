package com.freelancer.flow.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WorkLogEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectEntity project;

    private LocalDateTime workDate;
    private Double hoursWorked;
    private Boolean isRemote;


    @Override
    public String toString() {
        return String.format(
                "WorkLog=[id=%d, project=%s, workDate=%s, hoursWorked=%s, isRemote=%s]",
                getId(), getProject(), getWorkDate(), getHoursWorked(), getIsRemote()
        );
    }
}
