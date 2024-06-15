package com.freelancer.flow.entities;

import com.freelancer.flow.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProjectEntity extends BaseEntity {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recruiter_id", nullable = true)
    private RecruiterEntity recruiter;

    private String projectName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Override
    public String toString() {
        return String.format("Project=[client=%s, recruiter=%s, projectName=%s]", getClient().getId(), getRecruiter().getId(), getProjectName());
    }
}
