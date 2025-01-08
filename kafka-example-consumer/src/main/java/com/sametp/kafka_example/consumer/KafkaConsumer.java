package com.sametp.kafka_example.consumer;

import com.sametp.kafka_example.model.CustomEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer implements Receiver<String, CustomEvent> {
    @KafkaListener(
            groupId =  "${broker.group-id}",
            topics = {"${broker.topic.name}"}
    )
    public void receive(
            @Header(value = KafkaHeaders.RECEIVED_KEY, defaultValue = "null") String key,
            @Payload CustomEvent message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
            @Header(KafkaHeaders.OFFSET) Long offset
    ) {
        log.info("{} number of payment requests received with keys:{}, partitions:{} and offsets: {}", message, key, partition, offset);

    }
}
