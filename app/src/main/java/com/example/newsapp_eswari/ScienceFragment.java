package com.example.newsapp_eswari;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScienceFragment extends Fragment {
    String api="ee5d86f387bb4087a8ee4081c3084f3f";
    ArrayList<Model>modelArrayList;
    Adapter adapter;
    String country="us";
    private RecyclerView recyclerView_Science;
    private String category ="science";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.sciencefragment,null);

        recyclerView_Science=v.findViewById(R.id.recyclerviewScience);
        modelArrayList= new ArrayList<>();
        recyclerView_Science.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new Adapter(getContext(),modelArrayList);
        recyclerView_Science.setAdapter(adapter);
        findNews();
        return v;
    }

    private void findNews() {
        ApiUtility.getApiInterface().getCategoryNews(country,100,api,category)

                .enqueue(new Callback<MainNews>() {
                    @Override
                    public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                        if(response.isSuccessful()){
                            modelArrayList.addAll(response.body().getArticles());
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<MainNews> call, Throwable t) {

                    }
                });
    }
}
