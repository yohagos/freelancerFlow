package com.freelancer.flow.mappers;

import com.freelancer.flow.entities.EventEntity;
import com.freelancer.flow.responses.EventResponse;
import org.springframework.stereotype.Service;

@Service
public class EventMapper {

    public EventResponse toEventResponse(
            EventEntity event
    ) {
        return  EventResponse.builder()
                .id(event.getId())
                .category(event.getCategory().getCategory())
                .event(event.getEvent().getEvent())
                .categoryId(event.getCategoryId())
                .website(event.getWebsite())
                .phone(event.getPhone())
                .companyName(event.getCompanyName())
                .name(event.getName())
                .email(event.getEmail())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .projectName(event.getProjectName())
                .recruiterName(event.getRecruiterName())
                .remoteRate(event.getRemoteRate())
                .onSiteRate(event.getOnSiteRate())
                .workDate(event.getWorkDate())
                .hoursWorked(event.getHoursWorked())
                .isRemote(event.getIsRemote())
                .build();
    }

}
