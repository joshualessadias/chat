package com.joshuadias.chat.controllers;

import com.joshuadias.chat.dtos.request.ClientRequestDTO;
import com.joshuadias.chat.dtos.response.ClientResponseDTO;
import com.joshuadias.chat.services.client.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
