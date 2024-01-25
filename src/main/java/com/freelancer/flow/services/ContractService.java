package com.freelancer.flow.services;

import com.freelancer.flow.entities.ContractEntity;
import com.freelancer.flow.repositories.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

    public List<ContractEntity> getContracts() {
        return contractRepository.findAll();
    }
}
