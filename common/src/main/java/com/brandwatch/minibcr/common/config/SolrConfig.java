package com.brandwatch.minibcr.common.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = "com.brandwatch.minibcr")
public class SolrConfig {

    private final String solrHost = System.getenv("SOLR_HOST");

    @Bean
    public SolrClient solrClient() {
        HttpSolrClient solrClient = new HttpSolrClient.Builder(solrHost).build();
        solrClient.setParser(new XMLResponseParser());
        return solrClient;
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient solrClient) {
        return new SolrTemplate(solrClient);
    }
}
