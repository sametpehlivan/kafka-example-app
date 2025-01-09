package com.sametp.kafka_example.controller;


import com.sametp.kafka_example.producer.WikimediaStreamConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/publisher")
@RequiredArgsConstructor
@ResponseBody
public class WikimediaController {
    private final WikimediaStreamConsumer consumer;
    @GetMapping("/send-message")
    public void sendMessage(){
        consumer.consumeStreamAndPublishToBroker();
    }
}
