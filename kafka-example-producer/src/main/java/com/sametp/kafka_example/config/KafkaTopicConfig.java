package com.sametp.kafka_example.config;

import lombok.Getter;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Getter
@Configuration
public class KafkaTopicConfig {
    private final String topicName;
    public KafkaTopicConfig(@Value("${broker.topic.name}") String topicName){
        this.topicName = topicName;
    }
    @Bean
    public NewTopic topic(){
        return TopicBuilder
                .name(topicName)
                .partitions(1)
                .replicas(1)
                .build();
    }

}