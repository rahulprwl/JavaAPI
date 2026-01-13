package com.rahul.JavaAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.JavaAPI.handlers.MessageHandler;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageHandler _messageHandler;

    @GetMapping("send")
    public boolean sendMessage(String message) {
        return _messageHandler.sendMessageToTopic(message);
    }
}
