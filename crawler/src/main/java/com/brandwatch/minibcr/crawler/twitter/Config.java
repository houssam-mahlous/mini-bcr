package com.brandwatch.minibcr.crawler.twitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.redouane59.twitter.TwitterClient;
import com.github.redouane59.twitter.signature.TwitterCredentials;

@Configuration
public class Config {

    @Value("${twitter.accessToken}")
    String accessToken;
    @Value("${twitter.accessTokenSecret}")
    String accessTokenSecret;
    @Value("${twitter.apiKey}")
    String apiKey;
    @Value("${twitter.apiSecretKey}")
    private String apiSecretKey;
    @Value("${twitter.bearerToken}")
    private String bearerToken;

    @Bean
    public TwitterClient getTwitterClientInstance() {
        TwitterClient twitterClient = new TwitterClient(TwitterCredentials.builder()
                .accessToken(accessToken)
                .accessTokenSecret(accessTokenSecret)
                .apiKey(apiKey)
                .apiSecretKey(apiSecretKey)
                .build());
        return twitterClient;
    }
}
