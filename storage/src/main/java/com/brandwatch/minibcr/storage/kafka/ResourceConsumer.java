package com.brandwatch.minibcr.storage.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ResourceConsumer {

    private static final Logger log = LoggerFactory.getLogger(ResourceConsumer.class);

    //TODO: Store the resources in Solr
    @KafkaListener(topics = "resources", groupId = "resource-matching")
    public void consumeResources(String content) {
        log.info("Resource consumed from kafka topic resources with content: ", content);
    }
}
