package com.singleKafka.ProducerConsumer.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics="${app.topic.name}",groupId = "consumer-group-1")
    public void consumer(String message, @Header(KafkaHeaders.OFFSET) String offset){
        try{
            System.out.println("consumer consume the event {} " + message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
