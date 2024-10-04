package com.joshuadias.chat.services.message;

import com.joshuadias.chat.base.AbstractService;
import com.joshuadias.chat.dtos.request.MessageRequestDTO;
import com.joshuadias.chat.dtos.response.MessageResponseDTO;
import com.joshuadias.chat.mappers.ClientMapper;
import com.joshuadias.chat.mappers.MessageMapper;
import com.joshuadias.chat.models.Message;
import com.joshuadias.chat.repositories.MessageRepository;
import com.joshuadias.chat.services.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl extends AbstractService<MessageRepository, Message, Long>
        implements MessageService {

    private final ClientService clientService;

    @Override
    public MessageResponseDTO send(Long senderId, MessageRequestDTO request) {
        clientService.checkIfHasCredits(senderId);
        var entity = MessageMapper.toEntity(request);
        entity.setSender(ClientMapper.toEntity(senderId));
        var createdEntity = save(entity);
        return MessageMapper.toResponse(createdEntity);
    }
}
