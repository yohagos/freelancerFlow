package com.freelancer.flow.entities;

import com.freelancer.flow.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WorkLogEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private ProjectEntity project;
    private LocalDateTime workDate;
    private Double hoursWorked;
    private Boolean isRemote;
    @Column(columnDefinition = "TEXT", length = 1024)
    private String notice;

    @Override
    public String toString() {
        return String.format("WorkLog=[project=%s, event=%s, categoryId=%s, notice=%s]",
                getProject().getId(), getWorkDate(), getHoursWorked(), getNotice());
    }
}
