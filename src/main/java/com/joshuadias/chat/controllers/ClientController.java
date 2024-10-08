package com.joshuadias.chat.controllers;

import com.joshuadias.chat.dtos.request.client.ClientCreditsRequestDTO;
import com.joshuadias.chat.dtos.request.client.ClientPaymentPlanRequestDTO;
import com.joshuadias.chat.dtos.request.client.ClientRequestDTO;
import com.joshuadias.chat.dtos.response.ClientResponseDTO;
import com.joshuadias.chat.services.client.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(
            @RequestBody
            @Valid
            ClientRequestDTO request
    ) {
        return new ResponseEntity<>(service.create(request), CREATED);
    }

    @PutMapping("/{id}/add-credits")
    public ResponseEntity<ClientResponseDTO> addCredits(
            @PathVariable
            Long id,
            @RequestBody
            @Valid
            ClientCreditsRequestDTO request
    ) {
        return new ResponseEntity<>(service.addCredits(id, request), ACCEPTED);
    }

    @PutMapping("/{id}/alter-limit")
    public ResponseEntity<ClientResponseDTO> alterLimit(
            @PathVariable
            Long id,
            @RequestBody
            @Valid
            ClientCreditsRequestDTO request
    ) {
        return new ResponseEntity<>(service.alterLimit(id, request), ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> findById(
            @PathVariable
            Long id
    ) {
        return new ResponseEntity<>(service.findById(id), OK);
    }

    @GetMapping("/actual")
    public ResponseEntity<ClientResponseDTO> findActual(
            @RequestParam("id")
            Long id
    ) {
        return new ResponseEntity<>(service.findById(id), OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientResponseDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), OK);
    }

    @PutMapping("/{id}/alter-payment-plan")
    public ResponseEntity<ClientResponseDTO> alterPaymentPlan(
            @PathVariable
            Long id,
            @RequestBody
            @Valid
            ClientPaymentPlanRequestDTO request
    ) {
        return new ResponseEntity<>(service.alterPaymentPlan(id, request), ACCEPTED);
    }
}
