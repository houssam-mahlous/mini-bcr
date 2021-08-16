package com.brandwatch.minibcr.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.brandwatch.minibcr.api",
        "com.brandwatch.minibcr.common"})
@EntityScan("com.brandwatch.minibcr.common")
@EnableJpaRepositories("com.brandwatch.minibcr.common")
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
