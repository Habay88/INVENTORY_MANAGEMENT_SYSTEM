package com.sid.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.model.Conversation;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
}
