package com.example.whatsppChatbot.model;  // Changed from com.chatbot.model

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "conversations")
public class ConversationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_number")
    private String fromNumber;

    @Column(name = "user_message", columnDefinition = "TEXT")
    private String userMessage;

    @Column(name = "bot_response", columnDefinition = "TEXT")
    private String botResponse;

    @Column(name = "intent")
    private String intent;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "response_time_ms")
    private Long responseTimeMs;

    public ConversationHistory() {}

    public Long getId() { return id; }
    public String getFromNumber() { return fromNumber; }
    public String getUserMessage() { return userMessage; }
    public String getBotResponse() { return botResponse; }
    public String getIntent() { return intent; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public Long getResponseTimeMs() { return responseTimeMs; }


    public void setId(Long id) { this.id = id; }
    public void setFromNumber(String fromNumber) { this.fromNumber = fromNumber; }
    public void setUserMessage(String userMessage) { this.userMessage = userMessage; }
    public void setBotResponse(String botResponse) { this.botResponse = botResponse; }
    public void setIntent(String intent) { this.intent = intent; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public void setResponseTimeMs(Long responseTimeMs) { this.responseTimeMs = responseTimeMs; }
}