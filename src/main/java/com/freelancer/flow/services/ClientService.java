package com.freelancer.flow.services;

import com.freelancer.flow.common.PageResponse;
import com.freelancer.flow.entities.ClientEntity;
import com.freelancer.flow.mappers.ClientMapper;
import com.freelancer.flow.repositories.ClientRepository;
import com.freelancer.flow.requests.ClientRequest;
import com.freelancer.flow.responses.ClientResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.freelancer.flow.enums.CategoryEnum.CLIENT;
import static com.freelancer.flow.enums.EventEnum.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final EventService eventService;

    public PageResponse<ClientResponse> getClients(
            int page,
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<ClientEntity> clients = clientRepository
                .findAllDisplayableClients(pageable);
        List<ClientResponse> clientResponses = clients
                .stream()
                .map(clientMapper::toClientResponse)
                .toList();
        return new PageResponse<>(
                clientResponses,
                clients.getNumber(),
                clients.getSize(),
                clients.getTotalElements(),
                clients.getTotalPages(),
                clients.isFirst(),
                clients.isLast()
        );
    }

    public ClientResponse getClientById(Integer clientId) {
        return clientRepository.findById(clientId)
                .map(clientMapper::toClientResponse)
                .orElseThrow(() -> new EntityNotFoundException("Client with ID " + clientId + "could not be found"));
    }

    public Integer save(ClientRequest request) {
        var cl = clientMapper.toClient(request);
        var client = clientRepository.save(cl);

        eventService.createEventEntry(
                CLIENT,
                ADD,
                null,
                null,
                client,
                null,
                null
        );
        return client.getId();
    }

    public ClientResponse update(ClientRequest request) {
        var client = clientRepository.findById(request.getId())
                .orElseThrow();

        Optional.of(request.getClientName())
                .filter(name -> !name.isEmpty() || !name.equals(client.getClientName()))
                .ifPresent(client::setClientName);
        Optional.of(request.getClientEmail())
                .filter(email -> !email.isEmpty() || !email.equals(client.getClientEmail()))
                .ifPresent(client::setClientEmail);
        Optional.of(request.getCompanyName())
                .filter(name -> !name.isEmpty() || !name.equals(client.getCompanyName()))
                .ifPresent(client::setCompanyName);
        Optional.of(request.getWebsite())
                .filter(web -> !web.isEmpty() || !web.equals(client.getWebsite()))
                .ifPresent(client::setWebsite);
        Optional.of(request.getPhone())
                .filter(phone -> !phone.isEmpty() || !phone.equals(client.getPhone()))
                .ifPresent(client::setPhone);
        clientRepository.save(client);
        eventService.createEventEntry(
                CLIENT,
                EDIT,
                null,
                null,
                client,
                null,
                null
        );
        return clientMapper.toClientResponse(client);
    }


    public void delete(Integer clientId) {
        var client = clientRepository
                .findById(clientId)
                .orElseThrow();
        clientRepository.delete(client);
        eventService.createEventEntry(
                CLIENT,
                DELETE,
                null,
                null,
                client,
                null,
                null
        );
    }
}
