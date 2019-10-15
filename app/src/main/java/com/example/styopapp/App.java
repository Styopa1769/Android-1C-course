package com.example.styopapp;

import android.app.Application;

import com.example.styopapp.repo.NoteRepo;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NoteRepo.initialize(this);
    }
}
