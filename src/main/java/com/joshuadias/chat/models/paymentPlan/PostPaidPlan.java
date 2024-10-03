package com.joshuadias.chat.models.paymentPlan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "post_paid_plan")
public class PostPaidPlan extends ClientPaymentPlan {

    @Column(name = "credit_limit", nullable = false, precision = 12, scale = 2)
    private BigDecimal creditLimit = BigDecimal.valueOf(20);

    @Column(name = "credit_spent", nullable = false, precision = 12, scale = 2)
    private BigDecimal creditSpent = BigDecimal.ZERO;
}