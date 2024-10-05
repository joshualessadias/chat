package com.joshuadias.chat.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record MessageRequestDTO(

        @NotBlank(message = "Content is required")
        @Size(max = 500, message = "Content must have a maximum of 500 characters")
        String content,

        @NotBlank(message = "Receiver phone number is required")
        @Size(min = 11, max = 11, message = "Receiver phone number must have 11 characters")
        String receiverPhoneNumber,

        Boolean isWhatsApp
) {
}
