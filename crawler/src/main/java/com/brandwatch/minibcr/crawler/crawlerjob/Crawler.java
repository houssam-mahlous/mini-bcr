package com.brandwatch.minibcr.crawler.crawlerjob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.brandwatch.minibcr.common.domain.Resource;
import com.brandwatch.minibcr.crawler.services.CrawlerService;

@Component
public class Crawler {

    private final CrawlerService crawlerService;

    public Crawler(CrawlerService crawlerService) {
        this.crawlerService = crawlerService;
    }

    @Scheduled(fixedDelay = 5000)
    public void getResources() {
        crawlerService.fetchTweets();
    }
}
