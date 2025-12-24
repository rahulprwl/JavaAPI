package com.rahul.JavaAPI.handlers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.JavaAPI.gemini.ChatService;
import com.rahul.JavaAPI.models.geminimodels.MessageDTO;
import com.rahul.JavaAPI.repository.GeminiRepository;

@Service
public class ChatBotHandler {

    @Autowired
    private ChatService _chatService;
    @Autowired
    private GeminiRepository _geminiRepository;

    public String getChatBotResponse(String userMessage) {

        String sessionId = "default-session";
        List<MessageDTO> previousMessages = _geminiRepository.findBySessionId(sessionId);
        Date timestamp = new Date();
        String botResponse = _chatService.getResponse(userMessage);
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setUserMessage(userMessage);
        messageDTO.setBotResponse(botResponse);
        messageDTO.setTimestamp(timestamp);
        MessageDTO response = _geminiRepository.save(messageDTO);
        return botResponse;
    }
}
