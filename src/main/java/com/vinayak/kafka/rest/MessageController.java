package com.vinayak.kafka.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinayak.kafka.payload.Student;
import com.vinayak.kafka.producer.KafkaJsonProducer;
import com.vinayak.kafka.producer.KafkaProducer;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    
    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping("")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        
        return ResponseEntity.ok("Message Queued: " + message);
    }


    @PostMapping("/student")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student message) {
        kafkaJsonProducer.sendMessage(message);
        
        return ResponseEntity.ok("Message Queued: " + message);
    }

}
