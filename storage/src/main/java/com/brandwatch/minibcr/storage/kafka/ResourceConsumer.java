package com.brandwatch.minibcr.storage.kafka;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.brandwatch.minibcr.common.domain.Resource;
import com.brandwatch.minibcr.storage.services.ResourceStoreService;

@Component
public class ResourceConsumer {

    private static final Logger log = LoggerFactory.getLogger(ResourceConsumer.class);

    private final ResourceStoreService resourceStoreService;

    public ResourceConsumer(ResourceStoreService resourceStoreService) {
        this.resourceStoreService = resourceStoreService;
    }

    @KafkaListener(topics = "resources", groupId = "resource-matching")
    public void consumeResources(Resource resource) throws SolrServerException, IOException {
        log.info("Resource consumed from kafka topic resources");
        resourceStoreService.saveResource(resource);
    }
}
