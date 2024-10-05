package com.joshuadias.chat.services.client;

import com.joshuadias.chat.base.BaseService;
import com.joshuadias.chat.dtos.request.client.ClientCreditsRequestDTO;
import com.joshuadias.chat.dtos.request.client.ClientRequestDTO;
import com.joshuadias.chat.dtos.response.ClientResponseDTO;
import com.joshuadias.chat.exceptions.BadRequestException;
import com.joshuadias.chat.mappers.ClientMapper;
import com.joshuadias.chat.models.Client;
import com.joshuadias.chat.repositories.ClientRepository;
import com.joshuadias.chat.services.paymentPlan.PaymentPlanOrchestratorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (Boolean.TRUE.equals(repository.existsByPhoneNumber(request.phoneNumber())))
            throw new BadRequestException("Client already exists with phone number: " + request.phoneNumber());
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

    @Override
    public ClientResponseDTO addCredits(Long id, ClientCreditsRequestDTO request) {
        var entity = findByIdOrThrow(id);
        paymentPlanService.addCredits(entity.getPaymentPlan(), request);
        var updatedEntity = save(entity);
        return ClientMapper.toResponse(updatedEntity);
    }

    @Override
    public ClientResponseDTO alterLimit(Long id, ClientCreditsRequestDTO request) {
        var entity = findByIdOrThrow(id);
        paymentPlanService.alterLimit(entity.getPaymentPlan(), request);
        var updatedEntity = save(entity);
        return ClientMapper.toResponse(updatedEntity);
    }

    @Override
    public ClientResponseDTO findById(Long id) {
        var entity = findByIdOrThrow(id);
        return ClientMapper.toResponse(entity);
    }

    @Override
    public List<ClientResponseDTO> findAll() {
        var entityList = repository.findAll();
        return ClientMapper.toResponse(entityList);
    }
}
