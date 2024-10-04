package com.joshuadias.chat.controllers;

import com.joshuadias.chat.dtos.request.MessageRequestDTO;
import com.joshuadias.chat.dtos.response.MessageResponseDTO;
import com.joshuadias.chat.services.message.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService service;

    @PostMapping
    public ResponseEntity<MessageResponseDTO> send(
            // TODO: senderId should come from token
            @RequestParam("senderId")
            Long senderId,
            @RequestBody
            @Valid
            MessageRequestDTO request
    ) {
        return new ResponseEntity<>(service.send(senderId, request), CREATED);
    }
}
