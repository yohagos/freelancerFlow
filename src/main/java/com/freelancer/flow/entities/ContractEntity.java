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
public class ContractEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProjectEntity project;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double remoteRate;
    private Double onSiteRate;


    @Override
    public String toString() {
        return String.format(
                "Contract=[id=%d, project=%s, startDate=%s, endDate=%s, remoteRate=%d, onSiteRate=%d]",
                getId(), getProject(), getStartDate(), getEndDate(), getRemoteRate(), getOnSiteRate()
        );
    }
}
