package com.knoldus;

import java.io.*;
import java.util.List;
import twitter4j.Twitter;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.TwitterException;
import twitter4j.Status;
import twitter4j.TwitterFactory;

public class TwitterData {

    public  List<Status> getTweets() throws TwitterException, IOException {

        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey("blrWLmSO5XhhQML6HVXqqEje3")
                .setOAuthConsumerSecret("Oa88Kz0NbUymFPgUGDvynCOXuc3OzhYxEsZnKJfiYcBuyndAGG")
                .setOAuthAccessToken("1857592274-Qrcq73JRyqSthcH1vJ6nH8V38LLfTOJ0xOu22wm")
                .setOAuthAccessTokenSecret("Z59CxKDviuOUVDFu2qex08XekfElbITYczufaRm9LEOz7");

        TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
        Twitter twitter = twitterFactory.getInstance();

        return twitter.getHomeTimeline();
    }

    public void prettyPrint(Status status) {

        System.out.println("Date :" + status.getCreatedAt());
        System.out.println("Name :" + status.getUser().getScreenName());
        System.out.println("Likes :" + status.getFavoriteCount());
        System.out.println("ReTweets :" + status.getRetweetCount());
        System.out.println("Text :" + status.getText()+"\n\n");
    }

}
