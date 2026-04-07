package com.example.whatsppChatbot.model;  // Changed package

import java.time.LocalDateTime;

public class MessageResponse {
    private String reply;
    private String originalMessage;
    private LocalDateTime timestamp;
    private String botName;
    private String intent;
    private Long responseTimeMs;

    // Builder pattern
    public static class Builder {
        private String reply;
        private String originalMessage;
        private LocalDateTime timestamp;
        private String botName;
        private String intent;
        private Long responseTimeMs;

        public Builder reply(String reply) { this.reply = reply; return this; }
        public Builder originalMessage(String originalMessage) { this.originalMessage = originalMessage; return this; }
        public Builder timestamp(LocalDateTime timestamp) { this.timestamp = timestamp; return this; }
        public Builder botName(String botName) { this.botName = botName; return this; }
        public Builder intent(String intent) { this.intent = intent; return this; }
        public Builder responseTimeMs(Long responseTimeMs) { this.responseTimeMs = responseTimeMs; return this; }

        public MessageResponse build() {
            return new MessageResponse(this);
        }
    }

    private MessageResponse(Builder builder) {
        this.reply = builder.reply;
        this.originalMessage = builder.originalMessage;
        this.timestamp = builder.timestamp;
        this.botName = builder.botName;
        this.intent = builder.intent;
        this.responseTimeMs = builder.responseTimeMs;
    }

    public String getReply() { return reply; }
    public String getOriginalMessage() { return originalMessage; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getBotName() { return botName; }
    public String getIntent() { return intent; }
    public Long getResponseTimeMs() { return responseTimeMs; }

    public void setReply(String reply) { this.reply = reply; }
    public void setOriginalMessage(String originalMessage) { this.originalMessage = originalMessage; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public void setBotName(String botName) { this.botName = botName; }
    public void setIntent(String intent) { this.intent = intent; }
    public void setResponseTimeMs(Long responseTimeMs) { this.responseTimeMs = responseTimeMs; }
}