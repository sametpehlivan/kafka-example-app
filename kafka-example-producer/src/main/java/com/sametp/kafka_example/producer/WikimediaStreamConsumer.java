package com.sametp.kafka_example.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sametp.kafka_example.model.RecentChangeDataEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikimediaStreamConsumer {
    private final WebClient webClient;
    private final WikimediaProducer producer;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    public WikimediaStreamConsumer(WebClient.Builder webClientBuilder, WikimediaProducer producer){
        this.producer = producer;
        this.webClient = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
    }
    public void consumeStreamAndPublishToBroker(){
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .map(it -> {
                    try {
                        return fromJson(it);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .subscribe(event ->{
                    producer.sendMessage(event);
                });
    }
    public RecentChangeDataEvent fromJson(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, RecentChangeDataEvent.class);
    }
}

