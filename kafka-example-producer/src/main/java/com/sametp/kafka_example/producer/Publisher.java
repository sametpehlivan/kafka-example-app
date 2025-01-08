package com.sametp.kafka_example.producer;

public interface  Publisher<K,V>{

    void sendMessage(K key,V message);
    void sendMessage(V message);
}
