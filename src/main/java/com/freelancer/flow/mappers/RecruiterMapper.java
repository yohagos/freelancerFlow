package com.freelancer.flow.mappers;

import com.freelancer.flow.entities.RecruiterEntity;
import com.freelancer.flow.requests.RecruiterRequest;
import com.freelancer.flow.responses.RecruiterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RecruiterMapper {

    public RecruiterEntity toRecruiter(
            RecruiterRequest request
    ) {
        return RecruiterEntity.builder()
                .id(request.getId())
                .agency(request.getAgency())
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .website(request.getWebsite())
                .build();
    }

    public RecruiterResponse toRecruiterResponse(
            RecruiterEntity entity
    ) {
        return RecruiterResponse.builder()
                .id(entity.getId())
                .agency(entity.getAgency())
                .name(entity.getName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .website(entity.getWebsite())
                .build();
    }
}
