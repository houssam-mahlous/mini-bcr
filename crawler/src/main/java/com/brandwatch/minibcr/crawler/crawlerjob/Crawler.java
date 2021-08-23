package com.brandwatch.minibcr.crawler.crawlerjob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.brandwatch.minibcr.common.domain.Resource;
import com.brandwatch.minibcr.crawler.services.CrawlerService;

@Component
public class Crawler {

    @Autowired
    CrawlerService crawlerService;

    @Scheduled(fixedDelay = 5000)
    public void getResources() {
        Resource resource = crawlerService.fetchTweet();
        System.out.println(resource);
    }
}
