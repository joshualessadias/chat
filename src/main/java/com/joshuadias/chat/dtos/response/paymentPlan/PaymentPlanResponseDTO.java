package com.joshuadias.chat.dtos.response.paymentPlan;

import com.joshuadias.chat.enums.PaymentPlanEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PaymentPlanResponseDTO {
    private Long id;
    private PaymentPlanEnum type;
}