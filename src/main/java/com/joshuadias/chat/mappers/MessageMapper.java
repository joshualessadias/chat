package com.joshuadias.chat.mappers;

import com.joshuadias.chat.base.GenericMapper;
import com.joshuadias.chat.dtos.request.MessageRequestDTO;
import com.joshuadias.chat.dtos.response.MessageResponseDTO;
import com.joshuadias.chat.models.Message;

import java.util.List;

public class MessageMapper implements GenericMapper {

    private MessageMapper() {
    }

    public static MessageResponseDTO toResponse(Message entity) {
        return MessageResponseDTO.builder()
                .id(entity.getId())
                .createdAt(entity.getCreatedAt())
                .content(entity.getContent())
                .receiverPhoneNumber(entity.getReceiverPhoneNumber())
                .isWhatsApp(entity.getIsWhatsApp())
                .build();
    }

    public static List<MessageResponseDTO> toResponse(List<Message> entityList) {
        if (entityList == null || entityList.isEmpty()) return List.of();

        return entityList.stream().map(MessageMapper::toResponse).toList();
    }

    public static Message toEntity(MessageRequestDTO request) {
        var entity = new Message();
        entity.setContent(request.content());
        entity.setReceiverPhoneNumber(request.receiverPhoneNumber());
        entity.setIsWhatsApp(request.isWhatsApp());
        return entity;
    }
}
