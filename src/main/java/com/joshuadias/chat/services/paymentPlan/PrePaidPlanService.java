package com.joshuadias.chat.services.paymentPlan;

import com.joshuadias.chat.base.BaseService;
import com.joshuadias.chat.dtos.request.client.ClientCreditsRequestDTO;
import com.joshuadias.chat.exceptions.BadRequestException;
import com.joshuadias.chat.models.paymentPlan.ClientPaymentPlan;
import com.joshuadias.chat.models.paymentPlan.PrePaidPlan;
import com.joshuadias.chat.repositories.PrePaidPlanRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PrePaidPlanService extends BaseService<PrePaidPlanRepository, PrePaidPlan, Long>
        implements PaymentPlanService {

    private static final BigDecimal MESSAGE_VALUE = BigDecimal.valueOf(0.25);

    private void validateCredits(BigDecimal credits) {
        if (credits.compareTo(MESSAGE_VALUE) < 0)
            throw new BadRequestException("Insufficient credits to send message", HttpStatus.PAYMENT_REQUIRED);
    }

    @Override
    @Transactional
    public void handleMessageCredits(ClientPaymentPlan abstractEntity) {
        var entity = (PrePaidPlan) abstractEntity;
        validateCredits(entity.getCredits());
        entity.setCredits(entity.getCredits().subtract(MESSAGE_VALUE));
        save(entity);
    }

    @Override
    public void addCredits(ClientPaymentPlan abstractEntity, ClientCreditsRequestDTO request) {
        var entity = (PrePaidPlan) abstractEntity;
        entity.setCredits(entity.getCredits().add(request.credits()));
        save(entity);
    }

    @Override
    public void alterLimit(ClientPaymentPlan abstractEntity, ClientCreditsRequestDTO request) {
        throw new BadRequestException("Cannot alter limit to pre paid plan");
    }
}
