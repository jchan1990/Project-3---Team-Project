package com.example.qube.jjspost.api;

import com.example.qube.jjspost.models.Topic;

import java.security.SecureRandom;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by roosevelt on 8/18/16.
 */
public class UserData {
    List<Topic> mSubscriptions;
    List<Topic> mSections;
    private static UserData ourInstance = new UserData();

    public static UserData getInstance() {
        return ourInstance;
    }

    private UserData() {
        mSections = new LinkedList<>();
        mSections.add(new Topic("opinion", false));
        mSections.add(new Topic("world", false));
        mSections.add(new Topic("national", false));
        mSections.add(new Topic("politics", false));
        mSections.add(new Topic("upshot", false));
        mSections.add(new Topic("nyregion", false));
        mSections.add(new Topic("business", false));
        mSections.add(new Topic("technology", false));
        mSections.add(new Topic("science", false));
        mSections.add(new Topic("health", false));
        mSections.add(new Topic("sports", false));
        mSections.add(new Topic("arts", false));
        mSections.add(new Topic("books", false));
        mSections.add(new Topic("movies", false));
        mSections.add(new Topic("theater", false));
        mSections.add(new Topic("sundayreview", false));
        mSections.add(new Topic("fashion", false));
        mSections.add(new Topic("magazine", false));
        mSections.add(new Topic("food", false));
        mSections.add(new Topic("travel", false));
        mSections.add(new Topic("realestate", false));
        mSections.add(new Topic("automobiles", false));
        mSections.add(new Topic("obituaries", false));
        mSections.add(new Topic("insider", false));

        mSubscriptions = new LinkedList<>();
        setDummySubscriptions();


    }

    public String getSubscriptionsAsString(){
        String forQuery = "";
        if(mSubscriptions.isEmpty())
            return "nyregion";
        for (Topic subscription : mSubscriptions) {
            forQuery += subscription.getTopicName() + ";";
        }
        return forQuery.substring(0,forQuery.length() - 1);
    }
    public String getRandomSubscribedTopic(){
        Random random = new SecureRandom();
        random.setSeed((new Date()).getTime());
        int i = random.nextInt() % mSubscriptions.size();
        return mSubscriptions.get(i).getTopicName();
    }

    public void setDummySubscriptions(){
        mSubscriptions.add(new Topic("movies", true));
        mSubscriptions.add(new Topic("politics", true));
    }

    public void setSubscriptions(LinkedList<Topic> subscribedTopics){
        mSubscriptions.clear();
        for (Topic subscribedTopic : subscribedTopics) {
            if(subscribedTopic.isChecked())
                mSubscriptions.add(subscribedTopic);
        }
    }

    public LinkedList<Topic> getTopicsList(){
        return (LinkedList<Topic>) mSections;
    }

}
