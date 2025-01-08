package com.sametp.kafka_example.model;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class CustomEvent implements Serializable {
    private String messageId;
    private String content;
    private String eventType;
}
