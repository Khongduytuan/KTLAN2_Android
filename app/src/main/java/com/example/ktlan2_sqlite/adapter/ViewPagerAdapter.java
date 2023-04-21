package com.example.ktlan2_sqlite.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ktlan2_sqlite.fragment.HistoryFragment;
import com.example.ktlan2_sqlite.fragment.HomeFragment;
import com.example.ktlan2_sqlite.fragment.SearchFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new HomeFragment();
            case 1: return new HistoryFragment();
            case 2: return new SearchFragment();

        }
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
