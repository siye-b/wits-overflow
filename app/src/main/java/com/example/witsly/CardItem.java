package com.example.witsly;

public class CardItem {
    private String mPosterDetails;
    private String mPostTitle;
    private String mPostBody;
    private String mVoteCount;
    private String mCommentCount;

    public CardItem(String PosterDetails, String PostTitle, String PostBody, String VoteCount, String CommentCount){
        mPosterDetails = PosterDetails;
        mPostTitle = PostTitle;
        mPostBody = PostBody;
        mVoteCount = VoteCount;
        mCommentCount = CommentCount;
    }

    public String getPosterDetails(){
        return mPosterDetails;
    }

    public String getPostTitle(){
        return mPostTitle;
    }

    public String getPostBody(){
        return mPostBody;
    }

    public String getVoteCount(){
        return mVoteCount;
    }

    public String getCommentCount(){
        return mCommentCount;
    }
}
