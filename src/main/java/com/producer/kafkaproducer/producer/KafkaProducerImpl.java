package com.producer.kafkaproducer.producer;

import com.producer.kafkaproducer.config.KafkaProducerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.producer.kafkaproducer.utils.Constants.TOPIC;

@Service
public class KafkaProducerImpl {

    @Autowired
    KafkaProducerConfig kafkaProducerConfig;

    public boolean sendMessage(String person) {

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProducerConfig.getProps(), new StringSerializer(), new StringSerializer())) {
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, person);
            return producer.send(record).isDone();
        }

    }
}
