package com.example.newsapp_eswari;

import java.util.ArrayList;

public class MainNews {
    private String status;
    private String totalResult;
    private ArrayList<Model> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(String totalResult) {
        this.totalResult = totalResult;
    }

    public ArrayList<Model> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Model> articles) {
        this.articles = articles;
    }

    public MainNews(String status, String totalResult, ArrayList<Model> articles) {
        this.status = status;
        this.totalResult = totalResult;
        this.articles = articles;
    }
}
