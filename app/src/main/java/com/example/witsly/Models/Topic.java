package com.example.witsly.Models;

public class Topic {
    String Topic, TopicID;

    public Topic(){}


    public Topic(String topic) {
        this.Topic = topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getTopic() {
        return Topic;
    }

    public String getTopicID() {
        return TopicID;
    }
}
