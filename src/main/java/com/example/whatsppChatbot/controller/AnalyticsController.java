package com.example.whatsppChatbot.controller;

import com.example.whatsppChatbot.repository.MessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin(origins = "*")
public class AnalyticsController {

    private final MessageRepository messageRepository;

    public AnalyticsController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> getSummary() {
        Map<String, Object> analytics = new HashMap<>();
        analytics.put("totalMessages", messageRepository.count());
        analytics.put("uniqueUsers", messageRepository.findAll().stream()
                .map(m -> m.getFromNumber())
                .distinct()
                .count());
        analytics.put("status", "Active");
        analytics.put("database", "MySQL");
        return ResponseEntity.ok(analytics);
    }
}