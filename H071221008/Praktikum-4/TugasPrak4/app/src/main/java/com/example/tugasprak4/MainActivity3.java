package com.example.tugasprak4;

import android.view.View;


public final class MainActivity3 implements View.OnClickListener {
    public final MainActivity mainActivity;

    public MainActivity3 (MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public final void onClick(View view) {
        this.mainActivity.MainActivity3(view);
    }
}
