package com.joshuadias.chat.services.message;

import com.joshuadias.chat.dtos.request.MessageRequestDTO;
import com.joshuadias.chat.dtos.response.MessageResponseDTO;

public interface MessageService {

    MessageResponseDTO send(Long senderId, MessageRequestDTO request);
}
