package com.sametp.kafka_example.producer;

import com.sametp.kafka_example.config.KafkaTopicConfig;
import com.sametp.kafka_example.model.CustomEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer implements Publisher<String, CustomEvent> {
    private final KafkaTopicConfig topicConfig;
    private final KafkaTemplate<String, CustomEvent> kafkaTemplate;

    @Override
    public void sendMessage(String key, CustomEvent payload) {
        log.info("MESSAGE SENDING TO \nTOPIC [ {} ],\nKEY -> [ {} ],\nMESSAGE -> [ {} ]\n", topicConfig.getTopicName(), key, payload);

        kafkaTemplate.send(topicConfig.getTopicName(),key,payload);
    }

    public void sendMessage(CustomEvent message){
        sendMessage(null,message);
    }
}
