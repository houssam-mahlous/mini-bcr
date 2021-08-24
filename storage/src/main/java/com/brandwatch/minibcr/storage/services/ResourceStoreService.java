package com.brandwatch.minibcr.storage.services;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import com.brandwatch.minibcr.common.domain.Resource;

@Service
public class ResourceStoreService {

    private final SolrClient solrClient;

    private static final String SOLR_RESOURCES_COLLECTION = "resources";

    public ResourceStoreService(SolrClient solrClient) {
        this.solrClient = solrClient;
    }

    public void saveResource(Resource resource) throws SolrServerException, IOException {
        SolrInputDocument solrInputDocument = new SolrInputDocument();
        solrInputDocument.addField("resourceId", resource.getResourceId());
        solrInputDocument.addField("text", resource.getText());
        solrInputDocument.addField("author", resource.getAuthor());
        solrInputDocument.addField("createdAt", resource.getCreatedAt().toString());
        solrClient.add(SOLR_RESOURCES_COLLECTION, solrInputDocument);
        solrClient.commit(SOLR_RESOURCES_COLLECTION);
    }
}
