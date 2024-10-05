package com.joshuadias.chat.services.paymentPlan;

import com.joshuadias.chat.base.BaseService;
import com.joshuadias.chat.dtos.request.client.ClientCreditsRequestDTO;
import com.joshuadias.chat.exceptions.BadRequestException;
import com.joshuadias.chat.models.paymentPlan.ClientPaymentPlan;
import com.joshuadias.chat.models.paymentPlan.PostPaidPlan;
import com.joshuadias.chat.repositories.PostPaidPlanRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PostPaidPlanService extends BaseService<PostPaidPlanRepository, PostPaidPlan, Long>
        implements PaymentPlanService {

    private static final BigDecimal MESSAGE_VALUE = BigDecimal.valueOf(0.25);

    private void validateCredits(BigDecimal creditsSpent, BigDecimal creditLimit) {
        if (creditLimit.subtract(creditsSpent).compareTo(MESSAGE_VALUE) < 0)
            throw new BadRequestException("Account limit exceeded to send message", HttpStatus.UNAUTHORIZED);
    }

    @Override
    @Transactional
    public void handleMessageCredits(ClientPaymentPlan abstractEntity) {
        var entity = (PostPaidPlan) abstractEntity;
        validateCredits(entity.getCreditSpent(), entity.getCreditLimit());
        entity.setCreditSpent(entity.getCreditSpent().add(MESSAGE_VALUE));
        save(entity);
    }

    @Override
    public void addCredits(ClientPaymentPlan abstractEntity, ClientCreditsRequestDTO request) {
        throw new BadRequestException("Cannot add credits to post paid plan");
    }

    @Override
    public void alterLimit(ClientPaymentPlan abstractEntity, ClientCreditsRequestDTO request) {
        var entity = (PostPaidPlan) abstractEntity;
        entity.setCreditLimit(request.credits());
        save(entity);
    }
}
