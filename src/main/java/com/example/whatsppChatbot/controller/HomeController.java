package com.example.whatsppChatbot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>WhatsApp Chatbot</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        text-align: center;
                        padding: 50px;
                        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                        color: white;
                        margin: 0;
                    }
                    .container {
                        background: rgba(255,255,255,0.1);
                        border-radius: 20px;
                        padding: 40px;
                        max-width: 600px;
                        margin: auto;
                        backdrop-filter: blur(10px);
                    }
                    h1 { font-size: 48px; margin-bottom: 10px; }
                    .status {
                        background: #4CAF50;
                        padding: 10px 20px;
                        border-radius: 5px;
                        display: inline-block;
                        font-weight: bold;
                    }
                    .endpoint {
                        background: rgba(0,0,0,0.3);
                        padding: 10px;
                        margin: 10px;
                        border-radius: 5px;
                        font-family: monospace;
                    }
                    a {
                        color: white;
                        text-decoration: none;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>🤖 WhatsApp Chatbot</h1>
                    <div class="status">✅ DEPLOYED SUCCESSFULLY</div>
                    <p>Your WhatsApp chatbot is running on Railway!</p>
                    
                    <h3>📡 Available Endpoints:</h3>
                    <div class="endpoint">
                        <strong>GET /</strong> - Homepage<br>
                        <strong>GET /health</strong> - Health Check<br>
                        <strong>GET/POST /webhook</strong> - WhatsApp Webhook
                    </div>
                    
                    <p>🚀 Ready to receive WhatsApp messages</p>
                    <small>Deployed on Railway | Spring Boot</small>
                </div>
            </body>
            </html>
        """;
    }

    @GetMapping("/health")
    public String health() {
        return """
            {
                "status": "UP",
                "service": "WhatsApp-Chatbot",
                "deployment": "Railway",
                "timestamp": "%s"
            }
            """.formatted(java.time.Instant.now().toString());
    }
}