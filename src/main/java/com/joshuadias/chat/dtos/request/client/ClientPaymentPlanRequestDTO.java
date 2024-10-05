package com.joshuadias.chat.dtos.request.client;

import com.joshuadias.chat.enums.PaymentPlanEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ClientPaymentPlanRequestDTO(

        @NotNull(message = "Payment plan is required")
        PaymentPlanEnum paymentPlan
) {
}
