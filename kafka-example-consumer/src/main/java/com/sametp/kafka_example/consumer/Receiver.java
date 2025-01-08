package com.sametp.kafka_example.consumer;


import java.util.List;

public interface Receiver<K,V> {
    void receive( K key, V message, Integer partition, Long offset);
}
