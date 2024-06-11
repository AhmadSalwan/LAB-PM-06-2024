package com.example.tugasprak4;

import android.view.View;

public final class PostFragment4 implements View.OnClickListener {
    public final PostFragment postFragment;

    public PostFragment4 (PostFragment postFragment) {
        this.postFragment = postFragment;
    }

    public final void onClick(View view) {
        this.postFragment.PostFragment4(view);
    }
}
