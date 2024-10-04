package com.joshuadias.chat.services.client;

import com.joshuadias.chat.dtos.request.ClientRequestDTO;
import com.joshuadias.chat.dtos.response.ClientResponseDTO;

public interface ClientService {

    ClientResponseDTO create(ClientRequestDTO request);

    void checkIfHasCredits(Long senderId);
}
