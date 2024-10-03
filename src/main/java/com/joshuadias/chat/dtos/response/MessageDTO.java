package com.joshuadias.chat.dtos.response;

import lombok.Builder;

import java.util.Date;

@Builder
public record MessageDTO(
        Long id,
        Date createdAt,
        String content,
        Integer receiverPhoneNumber,
        Boolean isWhatsApp
) {
}