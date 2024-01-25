package com.freelancer.flow.services;

import com.freelancer.flow.entities.ClientEntity;
import com.freelancer.flow.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;


    public List<ClientEntity> getClients() {
        return clientRepository.findAll();
    }
}
