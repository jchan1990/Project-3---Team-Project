package com.example.qube.jjspost.models;

/**
 * Created by roosevelt on 8/19/16.
 */
public class Topic {
    private String mTopicName;
    private boolean mIsChecked;

    public Topic(String mTopicName, boolean mIsChecked) {
        this.mTopicName = mTopicName;
        this.mIsChecked = mIsChecked;
    }

    public String getTopicName() {
        return mTopicName;
    }

    public void setTopicName(String mTopicName) {
        this.mTopicName = mTopicName;
    }

    public boolean isChecked() {
        return mIsChecked;
    }

    public void setChecked(boolean mIsChecked) {
        this.mIsChecked = mIsChecked;
    }
}
