package com.joshuadias.chat.dtos.response.paymentPlan;

import com.joshuadias.chat.enums.PaymentPlanEnum;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PrePaidPlanResponseDTO extends PaymentPlanResponseDTO {
    private final BigDecimal credits;

    @Builder
    public PrePaidPlanResponseDTO(Long id, PaymentPlanEnum type, BigDecimal credits) {
        super(id, type);
        this.credits = credits;
    }
}
