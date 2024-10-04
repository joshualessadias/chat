package com.joshuadias.chat.mappers;

import com.joshuadias.chat.base.GenericMapper;
import com.joshuadias.chat.dtos.request.ClientRequestDTO;
import com.joshuadias.chat.dtos.response.ClientResponseDTO;
import com.joshuadias.chat.models.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientMapper implements GenericMapper {

    private final PaymentPlanMapper paymentPlanMapper;
    private final MessageMapper messageMapper;

    public Client toEntity(ClientRequestDTO request) {
        var entity = new Client();
        entity.setName(request.name());
        entity.setEmail(request.email());
        entity.setPhoneNumber(request.phoneNumber());
        entity.setCpf(request.cpf());
        entity.setCnpj(request.cnpj());
        entity.setFirmName(request.firmName());
        entity.setPaymentPlan(paymentPlanMapper.toEntity(request.paymentPlan()));
        entity.getPaymentPlan().setClient(entity);
        return entity;
    }

    public ClientResponseDTO toResponse(Client entity) {
        return ClientResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .cpf(entity.getCpf())
                .cnpj(entity.getCnpj())
                .firmName(entity.getFirmName())
                .paymentPlan(paymentPlanMapper.toResponse(entity.getPaymentPlan()))
                .messages(messageMapper.toResponse(entity.getMessages()))
                .build();
    }
}
