package com.joshuadias.chat.mappers;

import com.joshuadias.chat.base.GenericMapper;
import com.joshuadias.chat.dtos.response.MessageDTO;
import com.joshuadias.chat.models.Message;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageMapper implements GenericMapper {

    private MessageDTO toResponse(Message entity) {
        return MessageDTO.builder()
                .id(entity.getId())
                .createdAt(entity.getCreatedAt())
                .content(entity.getContent())
                .receiverPhoneNumber(entity.getReceiverPhoneNumber())
                .isWhatsApp(entity.getIsWhatsApp())
                .build();
    }

    public List<MessageDTO> toResponse(List<Message> entityList) {
        if (entityList == null || entityList.isEmpty()) return List.of();

        return entityList.stream().map(this::toResponse).toList();
    }
}
