package com.joshuadias.chat.mappers;

import com.joshuadias.chat.base.GenericMapper;
import com.joshuadias.chat.dtos.response.ClientPaymentPlanResponseDTO;
import com.joshuadias.chat.enums.PaymentPlanEnum;
import com.joshuadias.chat.exceptions.BadRequestException;
import com.joshuadias.chat.models.paymentPlan.ClientPaymentPlan;
import com.joshuadias.chat.models.paymentPlan.PostPaidPlan;
import com.joshuadias.chat.models.paymentPlan.PrePaidPlan;

public class PaymentPlanMapper implements GenericMapper {

    private PaymentPlanMapper() {
    }

    public static ClientPaymentPlan toEntity(PaymentPlanEnum paymentPlanEnum) {
        if (PaymentPlanEnum.PRE_PAID.equals(paymentPlanEnum))
            return new PrePaidPlan();
        else if (PaymentPlanEnum.POST_PAID.equals(paymentPlanEnum))
            return new PostPaidPlan();

        throw new BadRequestException("Invalid payment plan: " + paymentPlanEnum);
    }

    public static ClientPaymentPlanResponseDTO toResponse(ClientPaymentPlan entity) {
        return ClientPaymentPlanResponseDTO.builder()
                .id(entity.getId())
                .type(entity instanceof PrePaidPlan ? PaymentPlanEnum.PRE_PAID : PaymentPlanEnum.POST_PAID)
                .build();
    }
}
