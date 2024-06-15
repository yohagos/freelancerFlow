package com.freelancer.flow.services;

import com.freelancer.flow.common.PageResponse;
import com.freelancer.flow.entities.RecruiterEntity;
import com.freelancer.flow.mappers.RecruiterMapper;
import com.freelancer.flow.repositories.RecruiterRepository;
import com.freelancer.flow.requests.RecruiterRequest;
import com.freelancer.flow.responses.RecruiterResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.freelancer.flow.enums.CategoryEnum.RECRUITER;
import static com.freelancer.flow.enums.EventEnum.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecruiterService {

    private final RecruiterRepository recruiterRepository;
    private final RecruiterMapper recruiterMapper;
    private final EventService eventService;

    public PageResponse<RecruiterResponse> getRecruiters(int page, int size, Authentication connectedUser) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<RecruiterEntity> recruiters = recruiterRepository
                .findAllDisplayableRecruiters(pageable, connectedUser.getName());
        List<RecruiterResponse> recruiterResponses = recruiters.stream()
                        .map(recruiterMapper::toRecruiterResponse)
                                .toList();
        return new PageResponse<>(
            recruiterResponses,
            recruiters.getNumber(),
            recruiters.getSize(),
            recruiters.getTotalElements(),
            recruiters.getTotalPages(),
            recruiters.isFirst(),
            recruiters.isLast()
        );
    }

    public RecruiterResponse getRecruiter(Integer recruiterId) {
        return recruiterRepository.findById(recruiterId)
                .map(recruiterMapper::toRecruiterResponse)
                .orElseThrow(() -> new EntityNotFoundException("Contract with ID "+ recruiterId + "cannot be found"));
    }

    public Integer save(RecruiterRequest request) {
        var rec = recruiterMapper.toRecruiter(request);
        var recruiter = recruiterRepository.save(rec);
        eventService.createEventEntry(
                RECRUITER,
                ADD,
                null,
                recruiter,
                null,
                null,
                null
        );
        return recruiter.getId();
    }

    public RecruiterResponse update(RecruiterRequest request) {
        var recruiter = recruiterRepository.findById(request.getId())
                .orElseThrow();
        Optional.of(request.getAgency())
                .filter(name -> !name.isEmpty() || !name.contentEquals(recruiter.getAgency()))
                .ifPresent(recruiter::setAgency);
        Optional.of(request.getName())
                .filter(name -> !name.isEmpty() || !name.contentEquals(recruiter.getName()))
                .ifPresent(recruiter::setName);
        Optional.of(request.getEmail())
                .filter(email -> !email.isEmpty() || !email.contentEquals(recruiter.getEmail()))
                .ifPresent(recruiter::setEmail);
        Optional.of(request.getPhone())
                .filter(phone -> !phone.isEmpty() || !phone.contentEquals(recruiter.getPhone()))
                .ifPresent(recruiter::setPhone);
        Optional.of(request.getWebsite())
                .filter(web -> !web.isEmpty() || !web.contentEquals(recruiter.getWebsite()))
                .ifPresent(recruiter::setAgency);
        recruiterRepository.save(recruiter);
        eventService.createEventEntry(
                RECRUITER,
                EDIT,
                null,
                recruiter,
                null,
                null,
                null
        );
        return recruiterMapper.toRecruiterResponse(recruiter);
    }

    public void deleteRecruiter(Integer recruiterId) {
        var recruiter = recruiterRepository
                .findById(recruiterId)
                        .orElseThrow();
        log.warn(recruiter.toString());
        recruiterRepository.deleteById(recruiterId);

        eventService.createEventEntry(
                RECRUITER,
                DELETE,
                null,
                recruiter,
                null,
                null,
                null
        );
    }
}
