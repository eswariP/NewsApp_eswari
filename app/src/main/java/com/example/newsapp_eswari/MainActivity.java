package com.example.newsapp_eswari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String category,query;
TabLayout tabLayout;
TabItem shome,sScience,shealth,stech,sentertainment,sSports;
SearchView searchView;
PagerAdaptor pagerAdaptor;
Toolbar stoolbar;
String api="ee5d86f387bb4087a8ee4081c3084f3f";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView=findViewById(R.id.search);
        stoolbar =findViewById(R.id.toolbar);
        setSupportActionBar(stoolbar);
        shome =findViewById(R.id.home);
        sScience=findViewById(R.id.Science);
        sSports= findViewById(R.id.Sports);
        shealth =findViewById(R.id.health);
        stech= findViewById(R.id.tech);
        sentertainment=findViewById(R.id.Entertain);
        ViewPager viewPager=findViewById(R.id.fragmentContainer1);
        tabLayout = findViewById(R.id.include);
        pagerAdaptor = new PagerAdaptor(getSupportFragmentManager(),6);
         viewPager.setAdapter(pagerAdaptor);
         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
             @Override
             public boolean onQueryTextSubmit(String query) {
                   SearchFragment f= new SearchFragment();
                 searchView.getQueryHint();
                 return true;
             }

             @Override
             public boolean onQueryTextChange(String newText) {
                 searchView.getQuery().toString();
                 return true;
             }
         });
         tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {
                 viewPager.setCurrentItem(tab.getPosition());
                 if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5){
                     pagerAdaptor.notifyDataSetChanged();
                 }
             }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {

             }

             @Override
             public void onTabReselected(TabLayout.Tab tab) {

             }
         });

     viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }
}