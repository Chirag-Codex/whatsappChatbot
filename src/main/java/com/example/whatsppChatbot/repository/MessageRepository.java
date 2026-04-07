package com.example.whatsppChatbot.repository;  // Changed package

import com.example.whatsppChatbot.model.ConversationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<ConversationHistory, Long> {
}