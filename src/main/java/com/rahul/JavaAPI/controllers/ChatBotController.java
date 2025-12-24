package com.rahul.JavaAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.JavaAPI.handlers.ChatBotHandler;

@RestController
@RequestMapping("/chatbot")
public class ChatBotController {

    @Autowired
    private ChatBotHandler _chatBotHandler;

    @GetMapping("ask")
    public String AskQuestion(String userMessage) {
        return _chatBotHandler.getChatBotResponse(userMessage);
    }
}
