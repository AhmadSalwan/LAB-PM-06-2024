package com.example.tugasprak4;

import android.view.View;


public final class PostFragment3 implements View.OnClickListener {
    public final PostFragment postFragment;

    public PostFragment3 (PostFragment postFragment) {
        this.postFragment = postFragment;
    }

    public final void onClick(View view) {
        this.postFragment.PostFragment3(view);
    }
}