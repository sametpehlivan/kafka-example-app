package com.sametp.kafka_example.controller;

import com.sametp.kafka_example.model.CustomEvent;
import com.sametp.kafka_example.producer.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/publisher")
@RequiredArgsConstructor
@ResponseBody
public class ProduceMessage {
    private final Publisher<String, CustomEvent> kafkaProducer;
    @PostMapping("/send-message")
    public String sendMessage(@RequestBody String message){
        kafkaProducer.sendMessage(
                CustomEvent.builder()
                        .messageId(UUID.randomUUID().toString())
                        .content(message)
                        .eventType("CREATED")
                        .build()
        );
        return "Message queued, msg -> " + message;
    }


}
