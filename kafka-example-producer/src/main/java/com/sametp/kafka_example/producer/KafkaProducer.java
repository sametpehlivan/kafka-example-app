package com.sametp.kafka_example.producer;

import com.sametp.kafka_example.config.KafkaTopicConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer implements Publisher<String,String> {
    private final KafkaTopicConfig topicConfig;
    private final KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void sendMessage(String key, String message) {
        log.info("MESSAGE SENDING TO \nTOPIC [ {} ],\nKEY -> [ {} ],\nMESSAGE -> [ {} ]\n", topicConfig.getTopicName(), key, message);
        kafkaTemplate.send(topicConfig.getTopicName(),key,message);
    }

    public void sendMessage(String message){
        sendMessage(null,message);
    }
}
