package com.example.witsly;

public class CardItem {
    private final String mPosterDetails;
    private final String mPostTitle;
    private final String mPostBody;
    private final int mVoteCount;


    public CardItem(String title, String body, int vote, String details) {

        mPosterDetails = details;
        mPostTitle = title;
        mPostBody = body;
        mVoteCount = vote;

    }


    public String getPosterDetails() {

        return mPosterDetails;
    }

    public String getPostTitle() {
        return mPostTitle;
    }

    public String getPostBody() {
        return mPostBody;
    }

    public int getVoteCount() {
        return mVoteCount;
    }

}
