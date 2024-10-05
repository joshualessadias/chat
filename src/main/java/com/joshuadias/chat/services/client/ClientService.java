package com.joshuadias.chat.services.client;

import com.joshuadias.chat.dtos.request.client.ClientCreditsRequestDTO;
import com.joshuadias.chat.dtos.request.client.ClientPaymentPlanRequestDTO;
import com.joshuadias.chat.dtos.request.client.ClientRequestDTO;
import com.joshuadias.chat.dtos.response.ClientResponseDTO;
import com.joshuadias.chat.models.Client;

import java.util.List;

public interface ClientService {

    ClientResponseDTO create(ClientRequestDTO request);

    Client handleMessageCredits(Long senderId);

    ClientResponseDTO addCredits(Long id, ClientCreditsRequestDTO request);

    ClientResponseDTO alterLimit(Long id, ClientCreditsRequestDTO request);

    ClientResponseDTO findById(Long id);

    List<ClientResponseDTO> findAll();

    ClientResponseDTO alterPaymentPlan(Long id, ClientPaymentPlanRequestDTO request);
}
