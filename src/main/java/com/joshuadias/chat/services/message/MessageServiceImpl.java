package com.joshuadias.chat.services.message;

import com.joshuadias.chat.base.BaseService;
import com.joshuadias.chat.dtos.request.MessageRequestDTO;
import com.joshuadias.chat.dtos.response.MessageResponseDTO;
import com.joshuadias.chat.mappers.MessageMapper;
import com.joshuadias.chat.models.Message;
import com.joshuadias.chat.repositories.MessageRepository;
import com.joshuadias.chat.services.client.ClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl extends BaseService<MessageRepository, Message, Long>
        implements MessageService {

    private final ClientService clientService;

    @Override
    @Transactional
    public MessageResponseDTO send(Long senderId, MessageRequestDTO request) {
        var client = clientService.handleMessageCredits(senderId);
        var entity = MessageMapper.toEntity(request);
        entity.setSender(client);
        var createdEntity = save(entity);
        return MessageMapper.toResponse(createdEntity);
    }
}
