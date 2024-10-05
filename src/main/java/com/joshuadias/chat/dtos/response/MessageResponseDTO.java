package com.joshuadias.chat.dtos.response;

import lombok.Builder;

import java.util.Date;

@Builder
public record MessageResponseDTO(
        Long id,
        Date createdAt,
        String content,
        String receiverPhoneNumber,
        Boolean isWhatsApp
) {
}