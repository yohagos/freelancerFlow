package com.freelancer.flow.mappers;


import com.freelancer.flow.entities.ClientEntity;
import com.freelancer.flow.requests.ClientRequest;
import com.freelancer.flow.responses.ClientResponse;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {

    public ClientEntity toClient(ClientRequest request) {
        return ClientEntity.builder()
                .companyName(request.getCompanyName())
                .clientName(request.getClientName())
                .clientEmail(request.getClientEmail())
                .website(request.getWebsite())
                .phone(request.getPhone())
                .build();
    }

    public ClientResponse toClientResponse(ClientEntity entity) {
        return ClientResponse.builder()
                .id(entity.getId())
                .companyName(entity.getCompanyName())
                .clientName(entity.getClientName())
                .clientEmail(entity.getClientEmail())
                .website(entity.getWebsite())
                .phone(entity.getPhone())
                .build();
    }
}
