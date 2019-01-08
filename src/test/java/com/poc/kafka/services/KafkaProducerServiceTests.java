package com.poc.kafka.services;

import com.poc.kafka.KafkaApplicationTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class KafkaProducerServiceTests extends KafkaApplicationTests {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Test
    @DisplayName("should send a message to topic without exception")
    public void sendMessage() {
        assertDoesNotThrow(() -> kafkaProducerService.send("data of test"));
    }

}
