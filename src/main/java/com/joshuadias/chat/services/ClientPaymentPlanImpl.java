package com.joshuadias.chat.services;

import com.joshuadias.chat.base.AbstractService;
import com.joshuadias.chat.dtos.request.ClientRequestDTO;
import com.joshuadias.chat.dtos.response.ClientResponseDTO;
import com.joshuadias.chat.exceptions.BadRequestException;
import com.joshuadias.chat.mappers.ClientMapper;
import com.joshuadias.chat.models.Client;
import com.joshuadias.chat.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientPaymentPlanImpl extends AbstractService<ClientRepository, ClientMapper, Client, Long>
        implements ClientService {

    private void validateRequest(ClientRequestDTO request) {
        if (Boolean.TRUE.equals(repository.existsByEmail(request.email())))
            throw new BadRequestException("Client already exists with email: " + request.email());
        if (Boolean.TRUE.equals(repository.existsByCpf(request.cpf())))
            throw new BadRequestException("Client already exists with CPF: " + request.cpf());
        if (Boolean.TRUE.equals(repository.existsByCnpj(request.cnpj())))
            throw new BadRequestException("Client already exists with CNPJ: " + request.cnpj());
    }


    @Override
    @Transactional
    public ClientResponseDTO create(ClientRequestDTO request) {
        validateRequest(request);
        var entity = mapper.toEntity(request);
        var createdEntity = save(entity);
        return mapper.toResponse(createdEntity);
    }
}
