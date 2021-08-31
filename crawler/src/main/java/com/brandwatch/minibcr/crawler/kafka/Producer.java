package com.brandwatch.minibcr.crawler.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.brandwatch.minibcr.common.domain.Resource;

@Component
public class Producer {

    private static final String KAFKA_TOPIC = "resources";
    private static final Logger log = LoggerFactory.getLogger(Producer.class);
    private final KafkaTemplate<String, Resource> kafkaTemplate;

    public Producer(KafkaTemplate<String, Resource> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Resource resource) {
        log.info("sending resource: ", resource.getText());
        kafkaTemplate.send(KAFKA_TOPIC, String.valueOf(System.currentTimeMillis()), resource);
    }
}
