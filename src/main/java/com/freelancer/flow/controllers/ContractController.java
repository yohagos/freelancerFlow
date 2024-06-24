package com.freelancer.flow.controllers;

import com.freelancer.flow.common.PageResponse;
import com.freelancer.flow.requests.ContractRequest;
import com.freelancer.flow.responses.ContractResponse;
import com.freelancer.flow.services.ContractService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("contracts")
@RequiredArgsConstructor
@Tag(name = "Contracts")
public class ContractController {

    private final ContractService contractService;

    @GetMapping
    public ResponseEntity<PageResponse<ContractResponse>> getContracts(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size
    ) {
        return ResponseEntity.ok(contractService.getContracts(page, size));
    }

    @GetMapping("/{contractId}")
    public ResponseEntity<ContractResponse> getContract(
            @PathVariable("contractId") Integer contractId
    ) {
        return ResponseEntity.ok(contractService.getContractById(contractId));
    }

    @PostMapping
    public ResponseEntity<Integer> saveContract(
            @Valid @RequestBody ContractRequest request
    ) {
        return ResponseEntity.ok(contractService.save(request));
    }

    @PatchMapping
    public ResponseEntity<ContractResponse> updateContract(
            @Valid @RequestBody ContractRequest request
    ) {
        return ResponseEntity.ok(contractService.update(request));
    }

    @DeleteMapping("/remove/{contractId}")
    public ResponseEntity<?> deleteContract(
            @PathVariable("contractId") Integer contractId
    ) {
        contractService.delete(contractId);
        return ResponseEntity.accepted().build();
    }
}
