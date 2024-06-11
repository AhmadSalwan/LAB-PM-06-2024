package com.example.tugasprak4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;


public final class PostFragment2 implements ActivityResultCallback {
    public final PostFragment postFragment;

    public PostFragment2 (PostFragment postFragment) {
        this.postFragment = postFragment;
    }

    public final void onActivityResult(Object obj) {
        this.postFragment.PostFragment2((ActivityResult) obj);
    }
}