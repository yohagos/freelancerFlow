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
public class ContractEntity extends BaseEntity {
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectEntity project;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double remoteRate;
    private Double onSiteRate;

    @Override
    public String toString() {
        return String.format("Contract=[project=%s, startDate=%s, endDate=%s]", getProject().getId(), getStartDate(), getEndDate());
    }
}
