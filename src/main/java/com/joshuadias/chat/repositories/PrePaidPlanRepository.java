package com.joshuadias.chat.repositories;

import com.joshuadias.chat.base.GenericRepository;
import com.joshuadias.chat.models.paymentPlan.PrePaidPlan;
import org.springframework.stereotype.Repository;

@Repository
public interface PrePaidPlanRepository extends GenericRepository<PrePaidPlan, Long> {
}
