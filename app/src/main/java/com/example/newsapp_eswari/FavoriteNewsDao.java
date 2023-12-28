package com.example.newsapp_eswari;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavoriteNewsDao {
    @Insert
    void insertFavorite(FavoriteNews favoriteNews);

    @Query("SELECT * FROM favorite_news")
    List<FavoriteNews> getFavorites();

    @Query("DELETE FROM favorite_news WHERE id = :id")
    void deleteFavorite(int id);

    // To add a news article to favorites


}
