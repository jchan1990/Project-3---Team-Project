package com.example.qube.jjspost.api;

import java.security.SecureRandom;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by roosevelt on 8/18/16.
 */
public class UserData {
    List<String> mSubscriptions;
    List<String> mSections;
    private static UserData ourInstance = new UserData();

    public static UserData getInstance() {
        return ourInstance;
    }

    private UserData() {
        mSections = new LinkedList<>();
        mSections.add("opinion");
        mSections.add("world");
        mSections.add("national");
        mSections.add("politics");
        mSections.add("upshot");
        mSections.add("nyregion");
        mSections.add("business");
        mSections.add("technology");
        mSections.add("science");
        mSections.add("health");
        mSections.add("sports");
        mSections.add("arts");
        mSections.add("books");
        mSections.add("movies");
        mSections.add("theater");
        mSections.add("sundayreview");
        mSections.add("fashion");
        mSections.add("magazine");
        mSections.add("food");
        mSections.add("travel");
        mSections.add("realestate");
        mSections.add("automobiles");
        mSections.add("obituaries");
        mSections.add("insider");

        mSubscriptions = new LinkedList<>();
        setDummySubscriptions();


    }

    public String getSubscriptionsAsString(){
        String forQuery = "";
        for (String subscription : mSubscriptions) {
            forQuery += subscription + ";";
        }
        return forQuery.substring(0,forQuery.length() - 1);
    }
    public String getRandomSubscribedTopic(){
        Random random = new SecureRandom();
        random.setSeed((new Date()).getTime());
        int i = random.nextInt() % mSubscriptions.size();
        return mSubscriptions.get(i);
    }

    public void setDummySubscriptions(){
        mSubscriptions.add("sports");
        mSubscriptions.add("movies");
        mSubscriptions.add("politics");
    }

}
