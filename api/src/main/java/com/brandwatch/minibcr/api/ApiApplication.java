package com.brandwatch.minibcr.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {
        "com.brandwatch.minibcr.api",
        "com.brandwatch.minibcr.common",
        "com.brandwatch.minibcr.storage"
})
@EntityScan("com.brandwatch.minibcr.common")
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
