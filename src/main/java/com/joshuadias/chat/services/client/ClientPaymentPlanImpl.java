package com.joshuadias.chat.services.client;

import com.joshuadias.chat.base.BaseService;
import com.joshuadias.chat.dtos.request.ClientRequestDTO;
import com.joshuadias.chat.dtos.response.ClientResponseDTO;
import com.joshuadias.chat.exceptions.BadRequestException;
import com.joshuadias.chat.mappers.ClientMapper;
import com.joshuadias.chat.models.Client;
import com.joshuadias.chat.repositories.ClientRepository;
import com.joshuadias.chat.services.paymentPlan.PaymentPlanOrchestratorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientPaymentPlanImpl extends BaseService<ClientRepository, Client, Long>
        implements ClientService {

    private final PaymentPlanOrchestratorService paymentPlanService;

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
        var entity = ClientMapper.toEntity(request);
        var createdEntity = save(entity);
        return ClientMapper.toResponse(createdEntity);
    }

    private Client findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Client not found with id: " + id));
    }

    @Override
    public Client handleMessageCredits(Long senderId) {
        var entity = findByIdOrThrow(senderId);
        paymentPlanService.handleMessageCredits(entity.getPaymentPlan());
        return entity;
    }
}
