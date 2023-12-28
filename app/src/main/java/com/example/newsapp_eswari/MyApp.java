package com.example.newsapp_eswari;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;

public class MyApp extends Application {
    Context context;
    ArrayList<FavoriteNews> favoriteNews;
    public static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app_database")
                .build();
    }
}

