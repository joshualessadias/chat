package com.joshuadias.chat.services.paymentPlan;

import com.joshuadias.chat.models.paymentPlan.ClientPaymentPlan;
import com.joshuadias.chat.models.paymentPlan.PostPaidPlan;
import com.joshuadias.chat.models.paymentPlan.PrePaidPlan;
import com.joshuadias.chat.services.paymentPlan.postPaidPlan.PostPaidPlanService;
import com.joshuadias.chat.services.paymentPlan.prePaidPlan.PrePaidPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentPlanOrchestratorService {

    private final PrePaidPlanService prePaidPlanService;
    private final PostPaidPlanService postPaidPlanService;

    public void handleMessageCredits(ClientPaymentPlan entity) {
        if (entity instanceof PrePaidPlan prePaidPlanEntity) prePaidPlanService.handleMessageCredits(prePaidPlanEntity);
        else if (entity instanceof PostPaidPlan postPaidPlanEntity)
            postPaidPlanService.handleMessageCredits(postPaidPlanEntity);
    }
}
