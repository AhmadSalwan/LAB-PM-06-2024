package com.example.tugasprak4;

import com.example.tugasprak4.PostAdapter;
import com.example.tugasprak4.Post;

public final class HomeFragment3 implements PostAdapter.ClickListener {
    public final HomeFragment homeFragment;

    public HomeFragment3 (HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    public final void onDeleteButtonClicked(Post post) {
        this.homeFragment.HomeFragment3 (post);
    }
}
