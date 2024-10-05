package com.joshuadias.chat.mappers;

import com.joshuadias.chat.base.GenericMapper;
import com.joshuadias.chat.dtos.request.client.ClientRequestDTO;
import com.joshuadias.chat.dtos.response.ClientResponseDTO;
import com.joshuadias.chat.models.Client;

import java.util.List;

public class ClientMapper implements GenericMapper {

    private ClientMapper() {
    }

    public static Client toEntity(ClientRequestDTO request) {
        var entity = new Client();
        entity.setName(request.name());
        entity.setEmail(request.email());
        entity.setPhoneNumber(request.phoneNumber());
        entity.setCpf(request.cpf());
        entity.setCnpj(request.cnpj());
        entity.setFirmName(request.firmName());
        entity.setPaymentPlan(PaymentPlanMapper.toEntity(request.paymentPlan()));
        entity.getPaymentPlan().setClient(entity);
        return entity;
    }

    public static ClientResponseDTO toResponse(Client entity) {
        return ClientResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .cpf(entity.getCpf())
                .cnpj(entity.getCnpj())
                .firmName(entity.getFirmName())
                .paymentPlan(PaymentPlanMapper.toResponse(entity.getPaymentPlan()))
                .messages(MessageMapper.toResponse(entity.getMessages()))
                .build();
    }

    public static List<ClientResponseDTO> toResponse(List<Client> entityList) {
        if (entityList == null || entityList.isEmpty()) return List.of();

        return entityList.stream().map(ClientMapper::toResponse).toList();
    }
}
