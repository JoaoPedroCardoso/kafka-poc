package com.poc.kafka.services;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log
public class KafkaService extends Thread {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private String message = "";

    @Value("${kafka.person.bootstrap-topic}")
    private String topic;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        kafkaTemplate.send(topic, message);
    }

}
