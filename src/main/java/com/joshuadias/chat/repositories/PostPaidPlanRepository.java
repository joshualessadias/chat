package com.joshuadias.chat.repositories;

import com.joshuadias.chat.base.GenericRepository;
import com.joshuadias.chat.models.paymentPlan.PostPaidPlan;
import org.springframework.stereotype.Repository;

@Repository
public interface PostPaidPlanRepository extends GenericRepository<PostPaidPlan, Long> {
}
