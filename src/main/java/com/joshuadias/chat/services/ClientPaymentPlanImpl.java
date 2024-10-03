package com.joshuadias.chat.services;

import com.joshuadias.chat.base.AbstractServiceRepository;
import com.joshuadias.chat.dtos.request.ClientRequestDTO;
import com.joshuadias.chat.dtos.response.ClientResponseDTO;
import com.joshuadias.chat.models.Client;
import com.joshuadias.chat.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientPaymentPlanImpl extends AbstractServiceRepository<ClientRepository, Client, Long>
        implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public ClientResponseDTO create(ClientRequestDTO request) {
        return null;
    }
}
