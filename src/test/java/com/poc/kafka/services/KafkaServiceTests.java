package com.poc.kafka.services;

import com.poc.kafka.KafkaApplicationTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KafkaServiceTests extends KafkaApplicationTests {

    @Autowired
    private KafkaService kafkaService;

    @Test
    @DisplayName("should send a message to topic without exception")
    public void sendMessageTest() {
        assertDoesNotThrow(() -> kafkaService.run());
    }

    @Test
    @DisplayName("should set a message to kafkaService without exception")
    public void setMessageTest() {
        assertDoesNotThrow(() -> kafkaService.setMessage("test"));
        kafkaService.setMessage("test");
        assertEquals("test", kafkaService.getMessage());
    }

}
