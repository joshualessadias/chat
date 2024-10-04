package com.joshuadias.chat.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record MessageRequestDTO(

        @NotBlank(message = "Content is required")
        @Size(max = 500, message = "Content must have a maximum of 500 characters")
        String content,

        @NotNull(message = "Receiver phone number is required")
        Integer receiverPhoneNumber,

        Boolean isWhatsApp
) {
}
