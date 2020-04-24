package com.lisz;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;

@SpringBootApplication
public class KafkaMockApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(KafkaMockApplication.class);
        System.in.read();
    }

    @KafkaListeners(@KafkaListener(topics = {"topic01"}))
    public void receive(ConsumerRecord<String, String> record) {
        System.out.println("Topic: " + record.topic() + " key: " + record.key() + " value: " + record.value());
    }
}
