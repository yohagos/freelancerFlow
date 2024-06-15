package com.freelancer.flow.services;

import com.freelancer.flow.common.PageResponse;
import com.freelancer.flow.entities.*;
import com.freelancer.flow.enums.CategoryEnum;
import com.freelancer.flow.enums.EventEnum;
import com.freelancer.flow.mappers.EventMapper;
import com.freelancer.flow.repositories.EventRepository;
import com.freelancer.flow.responses.EventResponse;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public PageResponse<EventResponse> getRecentEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<EventEntity> events = eventRepository
                .findAllDisplayableEvents(pageable);
        List<EventResponse> eventResponses = events
                .stream()
                .map(eventMapper::toEventResponse)
                .toList();
        return new PageResponse<>(
                eventResponses,
                events.getNumber(),
                events.getSize(),
                events.getTotalElements(),
                events.getTotalPages(),
                events.isFirst(),
                events.isLast()
        );
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createEventEntry(
            CategoryEnum category,
            EventEnum event,
            @Nullable ProjectEntity project,
            @Nullable RecruiterEntity recruiter,
            @Nullable ClientEntity client,
            @Nullable ContractEntity contract,
            @Nullable WorkLogEntity workLog
            ) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setCategory(category);
        eventEntity.setEvent(event);

        if (project != null) {
            eventEntity.setProjectName(project.getProjectName());
            eventEntity.setStartDate(project.getStartDate());
            eventEntity.setEndDate(project.getEndDate());
            eventEntity.setCategoryId(project.getId());
        }
        if (recruiter != null) {
            eventEntity.setCompanyName(recruiter.getAgency());
            eventEntity.setName(recruiter.getName());
            eventEntity.setEmail(recruiter.getEmail());
            eventEntity.setPhone(recruiter.getPhone());
            eventEntity.setWebsite(recruiter.getWebsite());
            eventEntity.setCategoryId(recruiter.getId());
        }

        if (contract != null) {
            eventEntity.setProjectName(contract.getProject().getProjectName());
            eventEntity.setStartDate(contract.getStartDate());
            eventEntity.setEndDate(contract.getEndDate());
            eventEntity.setOnSiteRate(contract.getOnSiteRate());
            eventEntity.setRemoteRate(contract.getRemoteRate());
            eventEntity.setCategoryId(contract.getId());
        }

        if (client != null) {
            eventEntity.setCompanyName(client.getCompanyName());
            eventEntity.setName(client.getClientName());
            eventEntity.setEmail(client.getClientEmail());
            eventEntity.setPhone(client.getPhone());
            eventEntity.setWebsite(client.getWebsite());
            eventEntity.setCategoryId(client.getId());
        }

        if (workLog != null) {
            eventEntity.setProjectName(workLog.getProject().getProjectName());
            eventEntity.setWorkDate(workLog.getWorkDate());
            eventEntity.setHoursWorked(workLog.getHoursWorked());
            eventEntity.setIsRemote(workLog.getIsRemote());
            eventEntity.setCategoryId(workLog.getId());
            eventEntity.setNotice(workLog.getNotice());
        }
        eventRepository.save(eventEntity);
    }

    @Async
    public CompletableFuture<Void> createEventEntryAsync(
            CategoryEnum category,
            EventEnum event,
            @Nullable ProjectEntity project,
            @Nullable RecruiterEntity recruiter,
            @Nullable ClientEntity client,
            @Nullable ContractEntity contract,
            @Nullable WorkLogEntity workLog
    ) {
        return CompletableFuture.runAsync(() ->
                {
                    createEventEntry(category, event, project, recruiter, client, contract, workLog);
                }
        );
    }

}
