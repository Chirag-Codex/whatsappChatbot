package com.example.whatsppChatbot.controller;

import com.example.whatsppChatbot.model.*;
import com.example.whatsppChatbot.repository.MessageRepository;
import com.example.whatsppChatbot.service.ChatbotService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
@CrossOrigin(origins = "*")
public class WebhookController {

    private static final Logger log = LoggerFactory.getLogger(WebhookController.class);
    private final ChatbotService chatbotService;
    private final MessageRepository messageRepository;

    public WebhookController(ChatbotService chatbotService, MessageRepository messageRepository) {
        this.chatbotService = chatbotService;
        this.messageRepository = messageRepository;
    }

    @PostMapping
    public ResponseEntity<MessageResponse> receiveMessage(@Valid @RequestBody MessageRequest request) {
        long startTime = System.currentTimeMillis();

        log.info("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        log.info("📨 INCOMING: '{}' from: {}",
                request.getMessage(),
                request.getFrom() != null ? request.getFrom() : "Anonymous");

        String reply = chatbotService.getReply(request.getMessage());
        String intent = chatbotService.detectIntent(request.getMessage());
        long responseTime = System.currentTimeMillis() - startTime;

        ConversationHistory history = new ConversationHistory();
        history.setFromNumber(request.getFrom());
        history.setUserMessage(request.getMessage());
        history.setBotResponse(reply);
        history.setIntent(intent);
        history.setTimestamp(LocalDateTime.now());
        history.setResponseTimeMs(responseTime);

        messageRepository.save(history);

        log.info(" REPLY: '{}' (Intent: {}, Time: {}ms)", reply, intent, responseTime);
        log.info(" Saved to MySQL Database");
        log.info("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        MessageResponse response = new MessageResponse.Builder()
                .reply(reply)
                .originalMessage(request.getMessage())
                .timestamp(LocalDateTime.now())
                .botName("WhatsAppBot")
                .intent(intent)
                .responseTimeMs(responseTime)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("database", "MySQL Connected");
        health.put("totalMessages", messageRepository.count());
        health.put("timestamp", LocalDateTime.now());
        return ResponseEntity.ok(health);
    }
}