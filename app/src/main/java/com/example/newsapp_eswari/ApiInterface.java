package com.example.newsapp_eswari;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String BASE_URL="https://newsapi.org/v2/";
   //https://newsapi.org/v2/everything?q=Apple&from=2023-12-28&sortBy=popularity&apiKey=API_KEY
    //@GET("v2/top-headlines?country=us&apiKey=YOUR_API_KEY")

    @GET("top-headlines")
    Call<MainNews>getNews(
            @Query("country")String country,
            @Query("pageSize") int page_size,
            @Query("apiKey") String apikey



    );
    @GET("everything")
    Call<MainNews>SearchNews(
            @Query("country")String country,
            @Query("pageSize") int page_size,
            @Query("apiKey") String apikey,
            @Query("q")String q

    );


    @GET("top-headlines")
    Call<MainNews>getCategoryNews(
            @Query("country")String country,
            @Query("pageSize") int page_size,
            @Query("apiKey") String apikey,
            @Query("category")String category

    );
}

