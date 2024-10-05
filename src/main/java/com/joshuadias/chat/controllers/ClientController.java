package com.joshuadias.chat.controllers;

import com.joshuadias.chat.dtos.request.client.ClientAddCreditsRequestDTO;
import com.joshuadias.chat.dtos.request.client.ClientRequestDTO;
import com.joshuadias.chat.dtos.response.ClientResponseDTO;
import com.joshuadias.chat.services.client.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;

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

    // TODO: only backoffice can access this endpoint
    /**
     * If the client has a pre_paid plan, the credits will be added to the client's account.
     *
     * @param id      client id
     * @param request request with the credits to be added
     * @return client with the new credits
     */
    @PutMapping("/{id}/add-credits")
    public ResponseEntity<ClientResponseDTO> addCredits(
            @PathVariable
            Long id,
            @RequestBody
            @Valid
            ClientAddCreditsRequestDTO request
    ) {
        return new ResponseEntity<>(service.addCredits(id, request), ACCEPTED);
    }

    // TODO: only backoffice can access this endpoint
    /**
     * If the client has a post_paid plan, the credits will be set as a limit.
     *
     * @param id      client id
     * @param request request with the credits to be set as limit
     * @return client with the new limit
     */
    @PutMapping("/{id}/alter-limit")
    public ResponseEntity<ClientResponseDTO> alterLimit(
            @PathVariable
            Long id,
            @RequestBody
            @Valid
            ClientAddCreditsRequestDTO request
    ) {
        return new ResponseEntity<>(service.alterLimit(id, request), ACCEPTED);
    }
}
