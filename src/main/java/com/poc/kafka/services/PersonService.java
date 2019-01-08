package com.poc.kafka.services;

import com.poc.kafka.domain.Person;
import com.poc.kafka.repository.PersonRepository;
import com.poc.kafka.controller.exception.ObjectNotFoundException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private KafkaService kafkaService;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Person with ID " + id + " was not found."));
    }

    @Value("${kafka.person.bootstrap-topic}")
    private String topic;

    public Person save(Person person) throws InterruptedException {
        Person newPerson = personRepository.save(person);
        kafkaService.getMessage(newPerson.toString());
        kafkaService.run();
        kafkaService.join();
        log.info("Published data '" + newPerson + "' on topic " + topic);
        return newPerson;
    }

}
