package com.joshuadias.chat.dtos.response;

import com.joshuadias.chat.enums.PaymentPlanEnum;
import lombok.Builder;

@Builder
public record ClientPaymentPlanResponseDTO(
        Long id,
        PaymentPlanEnum type
) {
}