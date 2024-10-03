package com.joshuadias.chat.models.paymentPlan;

import com.joshuadias.chat.base.BaseModel;
import com.joshuadias.chat.models.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "client_payment_plan")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ClientPaymentPlan extends BaseModel {

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
}