package com.vinayak.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.vinayak.kafka.payload.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    
    // @KafkaListener(topics = "test-topic", groupId = "myGroup")
    public void consumeMsg(String message) {
        System.out.println("Message consumed " + message);
    }

    @KafkaListener(topics = "test-topic", groupId = "myGroup")
    public void consumeJsonMsg(Student student) throws InterruptedException {
        System.out.println("Message consumed " + student.toString());
        // add delay
        Thread.sleep(10000);
        System.out.println("Message consumed dd" + student.toString());
    }
}
