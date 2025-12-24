package com.rahul.JavaAPI.gemini;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class ChatService {

    private final Assistant assistant;
    private final ChatMemory chatMemory;

    public ChatService(ChatLanguageModel model) {
        // 1. Create unique memory for this specific user
        this.chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        // 2. Build the assistant with this specific memory
        this.assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .chatMemory(this.chatMemory)
                .build();
    }

    // Method 1: Take message and generate reply
    public String getResponse(String userMessage) {
        return assistant.chat(userMessage);
    }

    // Method 2: Close/Clear conversation
    public void clearConversation() {
        this.chatMemory.clear();
    }
}