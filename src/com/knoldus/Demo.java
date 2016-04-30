package com.knoldus;

import java.util.Comparator;
import java.util.List;
import twitter4j.Status;

public class Demo {

    public static void main(String[] args) {
        try {

            TwitterData tweets = new TwitterData();
            List<Status> list = tweets.getTweets();

            Comparator<Status> reTweets = (Status firstTweet,Status secondTweet) -> ((Integer)firstTweet.getRetweetCount()).compareTo((Integer)secondTweet.getRetweetCount());
            list.sort(reTweets);
            System.out.println("Number of reTweets :");
            list.stream().forEach(tweets::prettyPrint);

            Comparator<Status> likes = (Status firstTweet,Status secondTweet) -> ((Integer)firstTweet.getFavoriteCount()).compareTo((Integer)secondTweet.getFavoriteCount());
            list.sort(likes);
            System.out.println("Number of likes :");
            list.stream().forEach(tweets::prettyPrint);

            Comparator<Status> latestPost = (Status firstTweet,Status secondTweet) -> firstTweet.getCreatedAt().compareTo(secondTweet.getCreatedAt());
            list.sort(latestPost);
            System.out.println("Latest Posts are : ");
            list.stream().forEach(tweets::prettyPrint);


        }
        catch (Exception ex){

            System.out.println("Excepption : "+ex);
        }
    }
}
