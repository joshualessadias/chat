package com.joshuadias.chat.services.paymentPlan;

import com.joshuadias.chat.dtos.request.client.ClientAddCreditsRequestDTO;
import com.joshuadias.chat.models.paymentPlan.ClientPaymentPlan;
import com.joshuadias.chat.models.paymentPlan.PostPaidPlan;
import com.joshuadias.chat.models.paymentPlan.PrePaidPlan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentPlanOrchestratorService implements PaymentPlanService {

    private final PrePaidPlanService prePaidPlanService;
    private final PostPaidPlanService postPaidPlanService;

    @Override
    public void handleMessageCredits(ClientPaymentPlan abstractEntity) {
        if (abstractEntity instanceof PrePaidPlan)
            prePaidPlanService.handleMessageCredits(abstractEntity);
        else if (abstractEntity instanceof PostPaidPlan)
            postPaidPlanService.handleMessageCredits(abstractEntity);
    }

    @Override
    public void handleNewCredits(ClientPaymentPlan abstractEntity, ClientAddCreditsRequestDTO request) {
        if (abstractEntity instanceof PrePaidPlan)
            prePaidPlanService.handleNewCredits(abstractEntity, request);
        else if (abstractEntity instanceof PostPaidPlan)
            postPaidPlanService.handleNewCredits(abstractEntity, request);
    }
}
