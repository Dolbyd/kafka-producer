package com.producer.kafkaproducer.config;

import lombok.Getter;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

import static com.producer.kafkaproducer.utils.Constants.BOOTSTRAP_SERVER;

@Getter
@Configuration
public class KafkaProducerConfig {

    private Properties props = new Properties();

    public KafkaProducerConfig() {
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
    }
}
