package com.freelancer.flow.services;

import com.freelancer.flow.common.PageResponse;
import com.freelancer.flow.entities.ContractEntity;
import com.freelancer.flow.mappers.ContractMapper;
import com.freelancer.flow.repositories.ContractRepository;
import com.freelancer.flow.requests.ContractRequest;
import com.freelancer.flow.responses.ContractResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.freelancer.flow.enums.CategoryEnum.CONTRACT;
import static com.freelancer.flow.enums.EventEnum.*;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;
    private final EventService eventService;
    private final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    public PageResponse<ContractResponse> getContracts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<ContractEntity> contracts = contractRepository
                .findAllDisplayableContracts(pageable);
        List<ContractResponse> contractResponses = contracts
                .stream()
                .map(contractMapper::toContractResponse)
                .toList();
        return new PageResponse<>(
                contractResponses,
                contracts.getNumber(),
                contracts.getSize(),
                contracts.getTotalElements(),
                contracts.getTotalPages(),
                contracts.isFirst(),
                contracts.isLast()
        );
    }

    public ContractResponse getContractById(Integer contractId) {
        return contractRepository.findById(contractId)
                .map(contractMapper::toContractResponse)
                .orElseThrow(() -> new EntityNotFoundException("Contract with ID "+ contractId + "cannot be found"));
    }

    public Integer save(ContractRequest request) {
        var con = contractMapper.toContract(request);
        var contract = contractRepository.save(con);

        eventService.createEventEntryAsync(
                auth,
                CONTRACT,
                ADD,
                null,
                null,
                null,
                contract,
                null
        );
        return contract.getId();
    }

    public ContractResponse update(ContractRequest request) {
        var contract = contractRepository
                .findById(request.getId())
                .orElseThrow();

        Optional.of(request.getStartDate())
                .filter(date -> !date.isEqual(contract.getStartDate()))
                .ifPresent(contract::setStartDate);
        Optional.of(request.getEndDate())
                .filter(date -> !date.isEqual(contract.getEndDate()))
                .ifPresent(contract::setEndDate);
        Optional.of(request.getOnSiteRate())
                .filter(rate -> rate > 0 || !rate.equals(contract.getOnSiteRate()))
                .ifPresent(contract::setOnSiteRate);
        Optional.of(request.getRemoteRate())
                .filter(rate -> rate > 0 || !rate.equals(contract.getRemoteRate()))
                .ifPresent(contract::setRemoteRate);


        contractRepository.save(contract);

        eventService.createEventEntryAsync(
                auth,
                CONTRACT,
                EDIT,
                null,
                null,
                null,
                contract,
                null
        );
        return contractMapper.toContractResponse(contract);
    }

    public void delete(Integer contractId) {
        var contract = contractRepository
                .findById(contractId)
                .orElseThrow();
        eventService.createEventEntryAsync(
                auth,
                CONTRACT,
                DELETE,
                null,
                null,
                null,
                contract,
                null
        );
        contractRepository.deleteById(contractId);
    }
}
