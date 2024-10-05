package com.joshuadias.chat.dtos.response;

import com.joshuadias.chat.dtos.response.paymentPlan.PaymentPlanResponseDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record ClientResponseDTO(
        Long id,
        String name,
        String email,
        String phoneNumber,
        String cpf,
        String cnpj,
        String firmName,
        PaymentPlanResponseDTO paymentPlan,
        List<MessageResponseDTO> messages
) {
}