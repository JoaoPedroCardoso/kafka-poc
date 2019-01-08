package com.poc.kafka.controller;

import com.poc.kafka.controller.response.MessageResponse;
import com.poc.kafka.domain.MessageStorage;
import com.poc.kafka.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService producer;

    @Autowired
    private MessageStorage storage;

    @RequestMapping(value="/producer", method = RequestMethod.GET)
    public ResponseEntity<Void> producer(@RequestParam("data")String data){
        producer.send(data);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value="/consumer", method = RequestMethod.GET)
    public ResponseEntity<MessageResponse> getAllRecievedMessage(){
        String messages = storage.toString();
        storage.clear();

        return ResponseEntity.ok().body(new MessageResponse(messages));
    }

}
