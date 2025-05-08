package com.singleKafka.ProducerConsumer.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${app.topic.name}")
    private String topicName;


    public void sendMessage(String message){
        try{
            CompletableFuture<SendResult<String,Object>> futureResult= kafkaTemplate.send(topicName,message);
            futureResult.whenComplete((result, ex)->{
                if(ex==null){
                    System.out.println("Sent Message=["+message+
                            "] with offset=["+result.getRecordMetadata().offset()+"]"+ result.getRecordMetadata().partition());
                }
                else{
                    System.out.println("Unable to send message=["+
                            message+"] due to: "+ex.getMessage());
                }
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
