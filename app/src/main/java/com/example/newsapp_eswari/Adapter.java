package com.example.newsapp_eswari;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
     Context context;
     ArrayList<Model>modelArrayList;

    public Adapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.layout_newsitem,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        // we need set a data according to position
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,webView.class);
                intent.putExtra("url",modelArrayList.get(holder.getAdapterPosition()).getUrl());
                context.startActivity(intent);
            }
        });
        holder.NewsTime.setText("Published At"+modelArrayList.get(position).getPublishedAt());
        holder.newsAuthor.setText(modelArrayList.get(position).getAuthor());
        holder.NewsHeading.setText(modelArrayList.get(position).getTitle());
        holder.NewsContent.setText(modelArrayList.get(position).getDescription());
        Glide.with(context).load(modelArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView NewsHeading,NewsContent,newsAuthor,NewsTime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            NewsHeading = itemView.findViewById(R.id.mainHeading);
            NewsContent =itemView.findViewById(R.id.content1);
            newsAuthor=itemView.findViewById(R.id.author);
            NewsTime=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.image_view);
            cardView= itemView.findViewById(R.id.card_view_news);

        }
    }
}
