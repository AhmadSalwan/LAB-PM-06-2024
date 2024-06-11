package com.example.tugasprak4;

import android.view.View;
import com.example.tugasprak4.Post;


public final class PostAdapter2 implements View.OnClickListener {
    public final PostAdapter postAdapter;
    public final Post post;

    public PostAdapter2 (PostAdapter postAdapter, Post post) {
        this.postAdapter = postAdapter;
        this.post = post;
    }

    public final void onClick(View view) {
        this.postAdapter. PostAdapter2 (this.post, view);
    }
}