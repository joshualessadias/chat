package com.joshuadias.chat.repositories;

import com.joshuadias.chat.base.GenericRepository;
import com.joshuadias.chat.models.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends GenericRepository<Client, Long> {
}
