package com.example.witsly.Models;

public class Topic {
    String Topic, TopicID;

    public Topic(){}


    public Topic(String topic, String topicID) {
        this.Topic = topic;
        this.TopicID = topicID;
    }

    public Topic(String topic){
        this.Topic = topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public void setTopicID(String topicID) {TopicID = topicID;}

    public String getTopic() {
        return Topic;
    }

    public String getTopicID() {
        return TopicID;
    }

    @Override
    public String toString() {
        return Topic;
    }
}
