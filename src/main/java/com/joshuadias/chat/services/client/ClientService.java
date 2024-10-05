package com.joshuadias.chat.services.client;

import com.joshuadias.chat.dtos.request.client.ClientAddCreditsRequestDTO;
import com.joshuadias.chat.dtos.request.client.ClientRequestDTO;
import com.joshuadias.chat.dtos.response.ClientResponseDTO;
import com.joshuadias.chat.models.Client;

public interface ClientService {

    ClientResponseDTO create(ClientRequestDTO request);

    Client handleMessageCredits(Long senderId);

    ClientResponseDTO addCredits(Long id, ClientAddCreditsRequestDTO request);
}
