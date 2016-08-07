package com.example.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

public class OttoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otto_activity);
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

    @Subscribe
    public void onClick(ButtonClickEvent event) {
        Toast.makeText(getApplicationContext(), "Button clicked " + event.getClickCount() + " times.", Toast.LENGTH_SHORT).show();
    }

}
