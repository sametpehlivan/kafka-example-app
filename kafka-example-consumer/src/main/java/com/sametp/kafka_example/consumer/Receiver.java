package com.sametp.kafka_example.consumer;

public interface Receiver<K,V> {
    void receive( K key, V message, Integer partition, Long offset);
}