package com.example.newsapp_eswari;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdaptor extends FragmentPagerAdapter {
    int tabCount;

    public PagerAdaptor(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount=behavior;


    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new SportsFragment();
            case 2:
                return new Healthfragment();
            case 3:
                return new ScienceFragment();
            case 4:
                return new TechnologyFragment();
            case 5:
                return new EntertainmentFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
