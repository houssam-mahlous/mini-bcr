package com.brandwatch.minibcr.crawler.services;

import org.springframework.stereotype.Service;

import com.github.redouane59.twitter.TwitterClient;
import com.github.redouane59.twitter.dto.tweet.Tweet;

@Service
public class CrawlerService {

    public CrawlerService() {
        fetchTweets();
    }

    private void fetchTweets() {
        TwitterClient twitterClient = new TwitterClient();
        Tweet tweet = twitterClient.getTweet("1224041905333379073");
        System.out.println(tweet.getText());
        System.out.println(tweet.getCreatedAt());
        System.out.println(tweet.getLang());
        System.out.println(tweet.getLikeCount());
        System.out.println(tweet.getRetweetCount());
        System.out.println(tweet.getReplyCount());
        System.out.println(tweet.getUser().getName());
    }
}
