package com.example.tugas3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView ivLogo = findViewById(R.id.iv_logo);
        ImageView ivFeed = findViewById(R.id.iv_feed);
        TextView tvUsername = findViewById(R.id.tv_username);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvBio = findViewById(R.id.tv_bio);
        TextView tvPosts = findViewById(R.id.tv_posts);
        TextView tvFollowers = findViewById(R.id.tv_followers);
        TextView tvFollowing = findViewById(R.id.tv_following);

        Intent intent = getIntent();

        int imageLogo = intent.getIntExtra("LOGO_DEFAULT",0);
        int imageFeed = intent.getIntExtra("FEED_DEFAULT",0);
        String textUsername = intent.getStringExtra("USERNAME_DEFAULT");
        String textName = intent.getStringExtra("NAME_DEFAULT");
        String textBio = intent.getStringExtra("BIO_DEFAULT");
        String textPosts = intent.getStringExtra("POSTS_DEFAULT");
        String textFollowers = intent.getStringExtra("FOLLOWERS_DEFAULT");
        String textFollowing = intent.getStringExtra("FOLLOWING_DEFAULT");

        ivLogo.setImageResource(imageLogo);
        ivFeed.setImageResource(imageFeed);
        tvName.setText(textName);
        tvUsername.setText(textUsername);
        tvBio.setText(textBio);
        tvPosts.setText(textPosts);
        tvFollowers.setText(textFollowers);
        tvFollowing.setText(textFollowing);
    }
}