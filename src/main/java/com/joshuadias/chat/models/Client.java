package com.joshuadias.chat.models;

import com.joshuadias.chat.base.BaseModel;
import com.joshuadias.chat.models.paymentPlan.ClientPaymentPlan;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client extends BaseModel {

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 11, unique = true)
    private String phoneNumber;

    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "cnpj", nullable = false, unique = true, length = 14)
    private String cnpj;

    @Column(name = "firm_name", nullable = false, length = 50)
    private String firmName;

    @OneToOne(mappedBy = "client", cascade = CascadeType.PERSIST)
    private ClientPaymentPlan paymentPlan;

    @OneToMany(mappedBy = "sender")
    private List<Message> messages;
}
