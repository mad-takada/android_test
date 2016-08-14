package com.example.myapplication.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.bus.ButtonClickEvent;
import com.example.myapplication.bus.EventBusHolder;
import com.example.myapplication.R;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A placeholder fragment containing a simple view.
 */
public class OttoFragment extends Fragment {

    @BindView(R.id.vid_button) Button button1;

    @BindString(R.string.app_name) String app_name;

    private Unbinder unbinder;
    private int mClickCount;

    public OttoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.otto_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.vid_button)
    public void onClickButton(Button button) {
        EventBusHolder.EVENT_BUS.post(new ButtonClickEvent(mClickCount++));
    }
}
