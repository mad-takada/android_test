package com.example.myapplication.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.bus.ButtonClickEvent;
import com.example.myapplication.bus.EventBusHolder;
import com.example.myapplication.R;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBusHolder.EVENT_BUS.register(this);
    }

    @Override
    protected void onPause() {
        EventBusHolder.EVENT_BUS.unregister(this);
        super.onPause();
    }

    private void setViews(){
        FragmentManager manager = getSupportFragmentManager();
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        fragmentPagerAdapter adapter = new fragmentPagerAdapter(manager);
        viewPager.setAdapter(adapter);
    }

    @Subscribe
    public void onClick(ButtonClickEvent event) {
        Toast.makeText(getApplicationContext(), "Button clicked " + event.getClickCount() + " times.", Toast.LENGTH_SHORT).show();
    }

    public class fragmentPagerAdapter extends FragmentPagerAdapter {
        public fragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return 3;
        }
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new PicassoFragment();
                case 1:
                    return new OttoFragment();
                case 2:
                    return new RxFragment();
            }
            return null;
        }
        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "picasso";
                case 1:
                    return "otto";
                case 2:
                    return "rx";
            }
            return null;
        }
    }
}
