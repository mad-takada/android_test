package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vid_title) TextView title;
    @BindView(R.id.vie_button) TextView button;

    @BindString(R.string.app_name) String app_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
    }

    @Override
    public void onStart(){
        super.onStart();

        if (title != null) {
            title.setText("test");
        }
    }

    @OnClick(R.id.vie_button)
    public void onClickButton(Button button) {
        button.setText(app_name);
    }
}
