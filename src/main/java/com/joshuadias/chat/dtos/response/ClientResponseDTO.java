package com.joshuadias.chat.dtos.response;

import lombok.Builder;

import java.util.List;

@Builder
public record ClientResponseDTO(
        Long id,
        String name,
        String email,
        Integer phoneNumber,
        Integer cpf,
        Integer cnpj,
        String firmName,
        ClientPaymentPlanDTO paymentPlan,
        List<MessageDTO> messages
) {
}