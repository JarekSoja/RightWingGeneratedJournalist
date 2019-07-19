package com.soja.twitterbot.logger;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.util.Properties;

public class BotLogger {

    private String OAuthConsumerKey;
    private String OAuthConsumerSecret;
    private String OAuthAccessToken;
    private String OAuthAccessTokenSecret;
    private ConfigurationBuilder configurationBuilder;
    private TwitterFactory twitterFactory;
    private Twitter twitter;

    public BotLogger() {
        try {
            Properties properties = new Properties();
            properties.load(this.getClass().getClassLoader().getResourceAsStream("login.txt"));
            this.OAuthConsumerKey = properties.getProperty("OAuthConsumerKey");
            this.OAuthConsumerSecret = properties.getProperty("OAuthConsumerSecret");
            this.OAuthAccessToken = properties.getProperty("OAuthAccessToken");
            this.OAuthAccessTokenSecret = properties.getProperty("OAuthAccessTokenSecret");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setConfigurationBuilder() {
        configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(OAuthConsumerKey)
                .setOAuthConsumerSecret(OAuthConsumerSecret)
                .setOAuthAccessToken(OAuthAccessToken)
                .setOAuthAccessTokenSecret(OAuthAccessTokenSecret);
    }

    private void setTwitterFactory() {
        setConfigurationBuilder();
        twitterFactory = new TwitterFactory(configurationBuilder.build());
    }

    private void setTwitter() {
        setTwitterFactory();
        twitter = twitterFactory.getInstance();
    }

    public Twitter getTwitter() {
        if (twitter == null) {
            setTwitter();
            return twitter;
        } else {
            return twitter;
        }
    }

}



