package com.joshuadias.chat.services.paymentPlan.postPaidPlan;

import com.joshuadias.chat.models.paymentPlan.PostPaidPlan;

public interface PostPaidPlanService {

    void handleMessageCredits(PostPaidPlan entity);
}
