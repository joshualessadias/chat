package com.joshuadias.chat.services.message;

import com.joshuadias.chat.dtos.request.MessageRequestDTO;
import com.joshuadias.chat.models.Message;
import com.joshuadias.chat.repositories.MessageRepository;
import com.joshuadias.chat.services.client.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageServiceImplTest {

    @InjectMocks
    private MessageServiceImpl service;

    @Mock
    private ClientService clientService;

    @Mock
    private MessageRepository repository;

    @Test
    void test() {
        when(clientService.handleMessageCredits(anyLong())).thenReturn(null);
        when(repository.save(any())).thenReturn(new Message());

        var senderId = 1L;
        var request = MessageRequestDTO.builder().build();

        service.send(senderId, request);
        verify(clientService, times(1)).handleMessageCredits(senderId);
        verify(repository, times(1)).save(any());
    }
}
