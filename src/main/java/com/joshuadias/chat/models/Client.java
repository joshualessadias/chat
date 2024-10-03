package com.joshuadias.chat.models;

import com.joshuadias.chat.base.BaseModel;
import com.joshuadias.chat.models.paymentPlan.ClientPaymentPlan;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client extends BaseModel {

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private Integer phoneNumber;

    @Column(name = "cpf", nullable = false, unique = true)
    private Integer cpf;

    @Column(name = "cnpj", nullable = false, unique = true)
    private Integer cnpj;

    @Column(name = "firm_name", nullable = false, length = 50)
    private String firmName;

    @OneToOne
    private ClientPaymentPlan paymentPlan;
}
