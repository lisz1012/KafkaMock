package com.lisz;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Properties;

@SpringBootTest(classes = KafkaMockApplication.class)
@RunWith(SpringRunner.class)
public class KafkaProducerTest {
    @Autowired
    private IMessageSender sender;

    @Test
    public void testSend() {
        for (int i = 0; i < 3; i++) {
            sender.send("topic01", "lisz", "lisz1012");
        }
    }
}
