package com.joshuadias.chat.dtos.request.client;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ClientAddCreditsRequestDTO(

        @NotNull(message = "Credits is required")
        @Positive(message = "Credits must be greater than zero")
        BigDecimal credits
) {
}
