package com.brandwatch.minibcr.crawler.twitter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.redouane59.twitter.TwitterClient;
import com.github.redouane59.twitter.signature.TwitterCredentials;

@Configuration
public class Config {

    private final String accessToken = System.getenv("ACCESS_TOKEN");
    private final String accessTokenSecret = System.getenv("ACCESS_TOKEN_SECRET");
    private final String apiKey = System.getenv("API_KEY");
    private final String apiSecretKey = System.getenv("API_SECRET_KEY");
    private final String bearerToken = System.getenv("bearer_token");

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
