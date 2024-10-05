package com.joshuadias.chat.mappers;

import com.joshuadias.chat.base.GenericMapper;
import com.joshuadias.chat.dtos.response.paymentPlan.PaymentPlanResponseDTO;
import com.joshuadias.chat.dtos.response.paymentPlan.PostPaidPlanResponseDTO;
import com.joshuadias.chat.dtos.response.paymentPlan.PrePaidPlanResponseDTO;
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

    public static PaymentPlanResponseDTO toResponse(ClientPaymentPlan abstractEntity) {
        if (abstractEntity instanceof PrePaidPlan entity)
            return PrePaidPlanResponseDTO.builder()
                    .id(entity.getId())
                    .type(PaymentPlanEnum.PRE_PAID)
                    .credits(entity.getCredits())
                    .build();
        else if (abstractEntity instanceof PostPaidPlan entity)
            return PostPaidPlanResponseDTO.builder()
                    .id(entity.getId())
                    .type(PaymentPlanEnum.POST_PAID)
                    .creditLimit(entity.getCreditLimit())
                    .creditSpent(entity.getCreditSpent())
                    .build();

        throw new BadRequestException("Invalid payment plan: " + abstractEntity.getClass().getSimpleName());
    }
}
