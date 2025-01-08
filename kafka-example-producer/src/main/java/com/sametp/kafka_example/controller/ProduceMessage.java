package com.sametp.kafka_example.controller;

import com.sametp.kafka_example.producer.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publisher")
@RequiredArgsConstructor
@ResponseBody
public class ProduceMessage {
    private final Publisher<String,String> kafkaProducer;
    @PostMapping("/send-message")
    public String sendMessage(@RequestBody String message){
        kafkaProducer.sendMessage(message);
        return "Message queued, msg -> " + message;
    }


}
