package com.rahul.JavaAPI.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.JavaAPI.Adapters.Messenger.KafkaProducer;

@Service
public class MessageHandler {

    @Autowired
    private KafkaProducer _kafkaProducer;

    public boolean sendMessageToTopic(String message) {
        try {
            _kafkaProducer.sendMessage("Test", message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
