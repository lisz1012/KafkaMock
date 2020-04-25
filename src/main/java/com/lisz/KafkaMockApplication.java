package com.lisz;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;

@SpringBootApplication
public class KafkaMockApplication {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(KafkaMockApplication.class, args);
        IMessageSender sender = context.getBean(IMessageSender.class);
        Thread.sleep(12000);
        for (int i = 0; i < 9; i++) {
            sender.send("topic01", "lisz - " + i, "李书征 - " + i);
            Thread.sleep(1000);
        }
        System.in.read();
    }

    @KafkaListeners(@KafkaListener(topics = {"topic01"}))
    public void receive(ConsumerRecord<String, String> record) {
        System.out.println("Topic: " + record.topic() + " Partition: " + record.partition() + " key: " + record.key() + " value: " + record.value());
    }
}
