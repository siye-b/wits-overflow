package com.example.witsly.Activities;


import android.app.Application;

public class votesGlobalVar extends Application {

    private static votesGlobalVar singleton;

    public static int Asum = 0;
    public static int Psum = 0;
    public static int totsum = 0;


    public static votesGlobalVar getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }
}

