package com.joshuadias.chat.services.paymentPlan;

import com.joshuadias.chat.dtos.request.client.ClientCreditsRequestDTO;
import com.joshuadias.chat.models.paymentPlan.ClientPaymentPlan;

public interface PaymentPlanService {

    void handleMessageCredits(ClientPaymentPlan abstractEntity);

    void addCredits(ClientPaymentPlan abstractEntity, ClientCreditsRequestDTO request);

    void alterLimit(ClientPaymentPlan abstractEntity, ClientCreditsRequestDTO request);
}
