package com.joshuadias.chat.models;

import com.joshuadias.chat.base.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "message")
public class Message extends BaseModel {

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sender_id")
    private Client sender;

    @Column(name = "receiver_phone_number", nullable = false)
    private Integer receiverPhoneNumber;

    @Column(name = "is_whats_app", nullable = false)
    private Boolean isWhatsApp;
}
