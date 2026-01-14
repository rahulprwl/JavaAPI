package com.rahul.JavaAPI.Adapters.Messenger;

import java.util.concurrent.ExecutionException;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.rahul.JavaAPI.models.arraymodels.ArraysInput;

@Service
public class KafkaProducer {

    private KafkaTemplate<String, String> _kafkaTemplate;
    private KafkaTemplate<String, ArraysInput> _kafkaTemplate1;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate,
            KafkaTemplate<String, ArraysInput> kafkaTemplate1) {
        this._kafkaTemplate = kafkaTemplate;
        this._kafkaTemplate1 = kafkaTemplate1;
    }

    public void sendMessage(String topic, String message) {
        _kafkaTemplate.send(topic, message);
        _kafkaTemplate.flush();
    }

    public void sendMessage(String topic, ArraysInput message) throws InterruptedException, ExecutionException {
        _kafkaTemplate1.send(topic, message).get();
    }
}