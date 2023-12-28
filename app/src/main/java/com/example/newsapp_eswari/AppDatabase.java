package com.example.newsapp_eswari;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {FavoriteNews.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FavoriteNewsDao favoriteNewsDao();
}
