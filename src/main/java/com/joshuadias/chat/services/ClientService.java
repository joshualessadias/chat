package com.joshuadias.chat.services;

import com.joshuadias.chat.dtos.request.ClientRequestDTO;
import com.joshuadias.chat.dtos.response.ClientResponseDTO;

public interface ClientService {

    ClientResponseDTO create(ClientRequestDTO request);
}
