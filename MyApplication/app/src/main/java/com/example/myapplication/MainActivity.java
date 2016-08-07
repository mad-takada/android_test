package com.example.myapplication;

import android.content.Intent;
import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vid_title) TextView title;
    @BindView(R.id.vid_button) Button button;
    @BindView(R.id.vid_image)  ImageView image;

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
        button.setText(app_name);

        if (image != null) {
            Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(image);
        }
    }

    @OnClick(R.id.vid_button)
    public void onClickButton(Button button) {
        Intent intent = new Intent(this, FragmentActivity.class);
        startActivityForResult(intent,0);
    }
}
