package com.brandwatch.minibcr.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.brandwatch.minibcr.api",
        "com.brandwatch.minibcr.common",
})
@EntityScan({
        "com.brandwatch.minibcr.common",
})
@EnableSolrRepositories
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
