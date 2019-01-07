package com.poc.kafka.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.bootstrap-topic}")
    private String kafkaTopic;

    public void send(String data) {
        log.info("Published data '" + data + "' on topic " + kafkaTopic);

        kafkaTemplate.send(kafkaTopic, data);
    }
}
