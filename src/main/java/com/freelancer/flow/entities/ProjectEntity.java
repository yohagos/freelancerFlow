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
public class ProjectEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    private ClientEntity client;

    @Column(nullable = true)
    @ManyToMany(fetch = FetchType.LAZY)
    private RecruiterEntity recruiter;

    private String projectName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    @Override
    public String toString() {
        return String.format(
                "Project=[id=%d, client=%s, recruiter=%s, projectName=%s, startDate=%s, ednDate=%s]",
                getId(), getClient(), getRecruiter(), getProjectName(), getStartDate(), getEndDate()
        );
    }
}