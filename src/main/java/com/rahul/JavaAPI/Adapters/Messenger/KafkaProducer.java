package com.rahul.JavaAPI.Adapters.Messenger;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private KafkaTemplate<String, String> _kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this._kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        _kafkaTemplate.send(topic, message);
    }

}
