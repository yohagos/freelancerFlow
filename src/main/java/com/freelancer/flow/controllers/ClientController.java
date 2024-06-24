package com.freelancer.flow.controllers;

import com.freelancer.flow.common.PageResponse;
import com.freelancer.flow.requests.ClientRequest;
import com.freelancer.flow.responses.ClientResponse;
import com.freelancer.flow.services.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
@Tag(name = "Clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<PageResponse<ClientResponse>> getClients(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size
    ) {
        return ResponseEntity.ok(clientService.getClients(page, size));
    }

    @GetMapping("{clientId}")
    public ResponseEntity<ClientResponse> getClient(
            @PathVariable("clientId") Integer clientId
    ) {
        return ResponseEntity.ok(clientService.getClientById(clientId));
    }

    @PostMapping
    public ResponseEntity<Integer> saveClient(
            @Valid @RequestBody ClientRequest request
    ) {
        return ResponseEntity.ok(clientService.save(request));
    }

    @PatchMapping
    public ResponseEntity<ClientResponse> updateClient(
            @Valid @RequestBody ClientRequest request
    ) {
        return ResponseEntity.ok(clientService.update(request));
    }

    @DeleteMapping("/remove/{clientId}")
    public ResponseEntity<?> deleteClient(
            @PathVariable("clientId") Integer clientId
    ) {
        clientService.delete(clientId);
        return ResponseEntity.ok().build();
    }
}
