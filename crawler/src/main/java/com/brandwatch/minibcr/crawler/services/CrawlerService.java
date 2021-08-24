package com.brandwatch.minibcr.crawler.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.redouane59.twitter.TwitterClient;
import com.github.redouane59.twitter.dto.tweet.Tweet;

import com.brandwatch.minibcr.common.domain.Resource;
import com.brandwatch.minibcr.crawler.kafka.Producer;

@Service
public class CrawlerService {

    private final TwitterClient twitterClient;

    private final Producer producer;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CrawlerService(TwitterClient twitterClient, Producer producer) {
        this.twitterClient = twitterClient;
        this.producer = producer;
    }

    //TODO: Fetch a bunch of tweets (currently limited by the API)
    public void fetchTweets() {
        Tweet tweet = twitterClient.getTweet("1224041905333379073"); //A random ID for an existing tweet
        Resource resource = mapTweetToResource(tweet);
        producer.send(resource);
        logger.info("Crawled resource from twitter with content: {}", resource.getText());
    }

    public Resource mapTweetToResource(Tweet tweet) {
        Resource twitterResource = new Resource.Builder()
                .withId(tweet.getId())
                .fromAuthor(tweet.getUser().getName())
                .withText(tweet.getText())
                .createdAt(tweet.getCreatedAt())
                .build();
        return twitterResource;
    }
}
