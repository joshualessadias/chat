package com.joshuadias.chat.repositories;

import com.joshuadias.chat.base.GenericRepository;
import com.joshuadias.chat.models.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends GenericRepository<Client, Long> {

    Boolean existsByEmail(String email);

    Boolean existsByPhoneNumber(String phoneNumber);

    Boolean existsByCpf(String cpf);

    Boolean existsByCnpj(String cnpj);
}
