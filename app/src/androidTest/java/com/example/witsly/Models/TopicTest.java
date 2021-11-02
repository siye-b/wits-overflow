package com.example.witsly.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TopicTest {
    String TOPIC = "topic";
    String TOPICID = "topicid";

    private Topic topic;

    @Before
    public void initaliseObject(){topic = new Topic(TOPIC, TOPICID);}

    @Test
    public void setTopic(){
        String NEW_TOPIC = "new_topic";
        topic.setTopic(NEW_TOPIC);
        assertEquals(NEW_TOPIC, topic.getTopic());
    }

    @Test
    public void setTopicID(){
        String NEW_TOPICID = "new_topicid";
        topic.setTopicID(NEW_TOPICID);
        assertEquals(NEW_TOPICID,topic.getTopicID());
    }

    @Test
    public void getTopic(){
        assertEquals(TOPIC, topic.getTopic());
    }

    @Test
    public void getTopicID(){
        assertEquals(TOPICID, topic.getTopicID());
    }

    @Test
    public void tostring(){
        assertEquals(TOPIC, topic.toString());
    }

}