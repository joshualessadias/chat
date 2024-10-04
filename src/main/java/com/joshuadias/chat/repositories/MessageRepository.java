package com.joshuadias.chat.repositories;

import com.joshuadias.chat.base.GenericRepository;
import com.joshuadias.chat.models.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends GenericRepository<Message, Long> {
}
