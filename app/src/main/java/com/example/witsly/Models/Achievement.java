package com.example.witsly.Models;

public class Achievement {
    private int mImageResource;
    private String mText1;
    private String mText2;
    private int totVotes;
    private int totCommentVotes;

    private boolean j;
    // For Bonisiwe
    public Achievement(int imageResource, String text1, String text2){
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
    }

    public Achievement(int imageResource, String text1, String text2, boolean achieved){
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
        j = achieved;
    }

    public int getImageResource(){
        return mImageResource;
    }
    public String getText1(){
        return mText1;
    }
    public String getText2(){
        return mText2;
    }
    public boolean getAchieved(){return j;}
    public int getTotVotes(){
        return totVotes;
    }
    public void setTotVotes(int votes){
        this.totVotes = votes;
    }
    public int getTotCotes(){
        return totCommentVotes;
    }
    public void setTotCommentVotes(int votes){
        this.totCommentVotes = votes;
    }
}
