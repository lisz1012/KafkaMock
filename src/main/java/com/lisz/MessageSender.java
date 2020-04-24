package com.lisz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageSender implements IMessageSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String topic, String key, String value) {
        kafkaTemplate.send(topic, key, value);
    }
}
