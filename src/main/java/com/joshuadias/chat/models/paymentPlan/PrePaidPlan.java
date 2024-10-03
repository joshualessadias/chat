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
@Table(name = "pre_paid_plan")
public class PrePaidPlan extends ClientPaymentPlan {

    @Column(name = "credits", nullable = false, precision = 12, scale = 2)
    private BigDecimal credits = BigDecimal.ZERO;
}