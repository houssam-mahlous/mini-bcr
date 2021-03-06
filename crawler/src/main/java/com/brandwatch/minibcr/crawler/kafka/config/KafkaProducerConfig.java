package com.brandwatch.minibcr.crawler.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.brandwatch.minibcr.common.domain.Resource;

@Configuration
public class KafkaProducerConfig {

    private final String bootstrapServers = System.getenv("SPRING_KAFKA_BOOTSTRAP_SERVERS");

    @Bean
    public ProducerFactory<String, Resource> producerFactory() {

        Map<String, Object> configProperties = new HashMap<>();

        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        JsonSerializer<Resource> jsonSerializer = new JsonSerializer<>();
        return new DefaultKafkaProducerFactory<>(configProperties, new StringSerializer(), jsonSerializer);
    }

    @Bean
    public KafkaTemplate<String, Resource> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
