package com.brandwatch.minibcr.crawler.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.redouane59.twitter.TwitterClient;
import com.github.redouane59.twitter.dto.tweet.Tweet;

import com.brandwatch.minibcr.common.domain.Resource;

@Service
public class CrawlerService {

    private final TwitterClient twitterClient;

    public CrawlerService(TwitterClient twitterClient) {
        this.twitterClient = twitterClient;
    }

    //TODO: Fetch a bunch of tweets (currently limited by the API)
    public Resource fetchTweet() {
        Tweet tweet = twitterClient.getTweet("1224041905333379073"); //A random ID for an existing tweet
        return mapTweetToResource(tweet);
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
