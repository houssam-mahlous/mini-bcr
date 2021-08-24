package com.brandwatch.minibcr.storage.solr.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolrConfig {

    @Bean
    public SolrClient solrClient(@Value("${spring.data.solr.host}") String solrHost) {
        HttpSolrClient solrClient =  new HttpSolrClient.Builder(solrHost).build();
        solrClient.setParser(new XMLResponseParser());
        return solrClient;
    }
}
