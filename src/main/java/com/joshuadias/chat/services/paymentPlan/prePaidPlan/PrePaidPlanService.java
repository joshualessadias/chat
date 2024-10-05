package com.joshuadias.chat.services.paymentPlan.prePaidPlan;

import com.joshuadias.chat.models.paymentPlan.PrePaidPlan;

public interface PrePaidPlanService {

    void handleMessageCredits(PrePaidPlan entity);
}
