package com.example.whatsppChatbot.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ChatbotService {

    private final Map<String, String> responses = new HashMap<>();

    public ChatbotService() {
        responses.put("hi", "Hello! How can I help you?");
        responses.put("hello", "Hi there! Welcome!");
        responses.put("hey", "Hey! What's up?");
        responses.put("bye", "Goodbye! Have a great day!");
        responses.put("goodbye", "Bye! Take care!");
        responses.put("thanks", "You're welcome!");
        responses.put("thank you", "My pleasure!");
        responses.put("help", getHelpMessage());
    }

    public String getReply(String userMessage) {
        if (userMessage == null || userMessage.trim().isEmpty()) {
            return "Please say something! 😊";
        }

        String lowerMessage = userMessage.toLowerCase().trim();

        if (responses.containsKey(lowerMessage)) {
            return responses.get(lowerMessage);
        }

        if (lowerMessage.contains("hi") || lowerMessage.contains("hello")) {
            return responses.get("hi");
        }
        if (lowerMessage.contains("bye") || lowerMessage.contains("goodbye")) {
            return responses.get("bye");
        }
        if (lowerMessage.contains("thank")) {
            return responses.get("thanks");
        }

        return "I didn't understand. Try: Hi, Hello, Bye, Thanks, or Help 🤖";
    }

    public String detectIntent(String message) {
        String lowerMsg = message.toLowerCase();
        if (lowerMsg.contains("hi") || lowerMsg.contains("hello")) return "GREETING";
        if (lowerMsg.contains("bye") || lowerMsg.contains("goodbye")) return "FAREWELL";
        if (lowerMsg.contains("thank")) return "GRATITUDE";
        if (lowerMsg.contains("help")) return "HELP";
        return "UNKNOWN";
    }

    private String getHelpMessage() {
        return "📋 I understand: Hi, Hello, Bye, Goodbye, Thanks, Help";
    }
}