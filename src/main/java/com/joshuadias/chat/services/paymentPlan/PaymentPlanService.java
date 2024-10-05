package com.joshuadias.chat.services.paymentPlan;

import com.joshuadias.chat.dtos.request.client.ClientAddCreditsRequestDTO;
import com.joshuadias.chat.models.paymentPlan.ClientPaymentPlan;

public interface PaymentPlanService {

    void handleMessageCredits(ClientPaymentPlan abstractEntity);

    void handleNewCredits(ClientPaymentPlan abstractEntity, ClientAddCreditsRequestDTO request);
}
