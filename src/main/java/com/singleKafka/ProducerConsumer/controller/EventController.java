package com.singleKafka.ProducerConsumer.controller;

import com.singleKafka.ProducerConsumer.publisher.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/single-app")
public class EventController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?>publishMessage(@PathVariable String message){
        try{
            publisher.sendMessage(message);
            return ResponseEntity.ok("Message published successfully!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
