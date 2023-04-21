package com.example.ktlan2_sqlite;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;


import com.example.ktlan2_sqlite.adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavi;
    private ViewPager viewPager;
    private FloatingActionButton floating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        floating.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent);


        });

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0: bottomNavi.getMenu().findItem(R.id.mHome).setChecked(true);
                        break;
                    case 1: bottomNavi.getMenu().findItem(R.id.mHistory).setChecked(true);
                        break;
                    case 2: bottomNavi.getMenu().findItem(R.id.mSearch).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavi.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.mHome: viewPager.setCurrentItem(0);
                    break;
                case R.id.mHistory: viewPager.setCurrentItem(1);
                    break;
                case R.id.mSearch: viewPager.setCurrentItem(2);
                    break;
            }
            return true;
        });
    }

    private void anhXa() {
        bottomNavi = findViewById(R.id.bottomNavi);
        viewPager = findViewById(R.id.viewPager);
        floating = findViewById(R.id.floating);
    }
}