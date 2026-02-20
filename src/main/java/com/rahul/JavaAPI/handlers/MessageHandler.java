package com.rahul.JavaAPI.handlers;

import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.JavaAPI.Adapters.Messenger.KafkaProducer;

@Service
public class MessageHandler {

    @Autowired
    private KafkaProducer _kafkaProducer;

    @McpTool(name = "sendMessageToDefaultTopic", description = "Send a message to default Topic")
    public boolean sendMessageToTopic(String message) {
        return sendMessageToTopic(message, "Test");
    }

    @McpTool(name = "sendMessageToTopic", description = "Send a message to a topic")
    public boolean sendMessageToTopic(String message, String topic) {
        try {
            _kafkaProducer.sendMessage(topic, message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
