package com.example.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentActivityFragment extends Fragment {

    @BindView(R.id.vid_button) Button button1;

    @BindString(R.string.app_name) String app_name;

    private int mClickCount;

    public FragmentActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.vid_button)
    public void onClickButton(Button button) {
        EventBusHolder.EVENT_BUS.post(new ButtonClickEvent(mClickCount++));
    }
}
