package com.sametp.kafka_example.producer;

import com.sametp.kafka_example.config.KafkaTopicConfig;
import com.sametp.kafka_example.model.RecentChangeDataEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikimediaProducer implements Publisher<String, RecentChangeDataEvent> {
    private final KafkaTopicConfig topicConfig;
    private final KafkaTemplate<String, RecentChangeDataEvent> kafkaTemplate;


    public void sendMessage(String key, RecentChangeDataEvent message) {
        log.info("MESSAGE SENDING TO \nTOPIC [ {} ],\nKEY -> [ {} ],\nMESSAGE -> [ {} ]\n", topicConfig.getTopicName(), key, message);
        kafkaTemplate.send(topicConfig.getTopicName(), key, message);
    }

    public void sendMessage(RecentChangeDataEvent message) {
        sendMessage(null, message);

    }
}
