package com.freelancer.flow.mappers;

import com.freelancer.flow.entities.ContractEntity;
import com.freelancer.flow.entities.ProjectEntity;
import com.freelancer.flow.requests.ContractRequest;
import com.freelancer.flow.responses.ContractResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractMapper {

    public ContractEntity toContract(
            ContractRequest request
    ) {
        return ContractEntity.builder()
                .id(request.getId())
                .project(
                        ProjectEntity.builder()
                                .id(request.getProjectId())
                                .build()
                )
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .remoteRate(request.getRemoteRate())
                .onSiteRate(request.getOnSiteRate())
                .build();
    }

    public ContractResponse toContractResponse(
        ContractEntity entity
    ) {
        return ContractResponse.builder()
                .id(entity.getId())
                .project(entity.getProject())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .onSiteRate(entity.getOnSiteRate())
                .remoteRate(entity.getRemoteRate())
                .build();
    }
}
