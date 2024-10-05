package com.joshuadias.chat.services.paymentPlan.prePaidPlan;

import com.joshuadias.chat.base.BaseService;
import com.joshuadias.chat.exceptions.BadRequestException;
import com.joshuadias.chat.models.paymentPlan.PrePaidPlan;
import com.joshuadias.chat.repositories.PrePaidPlanRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PrePaidPlanServiceImpl extends BaseService<PrePaidPlanRepository, PrePaidPlan, Long>
        implements PrePaidPlanService {

    private static final BigDecimal MESSAGE_VALUE = BigDecimal.valueOf(0.25);

    private void validateCredits(BigDecimal credits) {
        if (credits.compareTo(MESSAGE_VALUE) < 0)
            throw new BadRequestException("Insufficient credits to send message", HttpStatus.PAYMENT_REQUIRED);
    }

    @Override
    @Transactional
    public void handleMessageCredits(PrePaidPlan entity) {
        validateCredits(entity.getCredits());
        entity.setCredits(entity.getCredits().subtract(MESSAGE_VALUE));
        save(entity);
    }
}
