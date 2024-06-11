package com.example.tugasprak4;

import com.example.tugasprak4.ConfirmDialogFragment;
import com.example.tugasprak4.Post;


public final class HomeFragment2 implements ConfirmDialogFragment.DialogListener {
    public final HomeFragment homeFragment;
    public final Post post;

    public HomeFragment2 (HomeFragment homeFragment, Post post) {
        this.homeFragment = homeFragment;
        this.post = post;
    }

    public final void setOnClickDeleteButton() {
        this.homeFragment.HomeFragment2(this.post);
    }
}