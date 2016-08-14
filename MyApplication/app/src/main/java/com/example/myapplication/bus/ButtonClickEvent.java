package com.example.myapplication.bus;

public class ButtonClickEvent {
    private final int mClickCount;

    public ButtonClickEvent(final int clickCount) {
        mClickCount = clickCount;
    }

    public int getClickCount() {
        return mClickCount;
    }
}
