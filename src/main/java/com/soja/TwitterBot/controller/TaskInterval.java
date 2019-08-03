package com.soja.TwitterBot.controller;

import com.soja.TwitterBot.generator.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.Timer;
import java.util.TimerTask;

public class TaskInterval {

    private int delay;
    private int interval;

    public void startTask(Twitter twitter, Tweet tweet) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    twitter.updateStatus(tweet.getTweetContent());
                } catch (TwitterException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, this.delay, this.interval);
    }
}

