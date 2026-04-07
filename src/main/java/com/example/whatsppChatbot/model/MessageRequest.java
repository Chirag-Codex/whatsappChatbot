package com.example.whatsppChatbot.model;  // Changed package

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageRequest {
    @JsonProperty("message")
    private String message;

    @JsonProperty("from")
    private String from;

    @JsonProperty("sessionId")
    private String sessionId;

    public String getMessage() { return message; }
    public String getFrom() { return from; }
    public String getSessionId() { return sessionId; }

    public void setMessage(String message) { this.message = message; }
    public void setFrom(String from) { this.from = from; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
}