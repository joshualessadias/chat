package com.joshuadias.chat.dtos.response.paymentPlan;

import com.joshuadias.chat.enums.PaymentPlanEnum;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PostPaidPlanResponseDTO extends PaymentPlanResponseDTO {
    private final BigDecimal creditLimit;
    private final BigDecimal creditSpent;

    @Builder
    public PostPaidPlanResponseDTO(Long id, PaymentPlanEnum type, BigDecimal creditLimit, BigDecimal creditSpent) {
        super(id, type);
        this.creditLimit = creditLimit;
        this.creditSpent = creditSpent;
    }
}
