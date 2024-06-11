package com.example.tugasprak4;

import android.view.View;


public final class MainActivity4 implements View.OnClickListener {
    public final MainActivity mainActivity;

    public MainActivity4 (MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public final void onClick(View view) {
        this.mainActivity.MainActivity4 (view);
    }
}
