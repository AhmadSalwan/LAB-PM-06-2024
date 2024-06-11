package com.example.tugasprakktikum3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageView iv_profile;
    private ImageView iv_feed;
    private TextView tv_nama, tv_followers, tv_following;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();

        AccountIg accountIgs = intent.getParcelableExtra("accountIg");


        // Inisialisasi views
        iv_profile = findViewById(R.id.iv_profile_acc);
        iv_feed = findViewById(R.id.iv_post_acc);
        tv_nama = findViewById(R.id.tv_username_acc);
        tv_followers = findViewById(R.id.followers_acc);
        tv_following = findViewById(R.id.following_acc);

        // Menampilkan data universitas pada views
        iv_profile.setImageResource(accountIgs.getImageProfile());
        iv_feed.setImageResource(accountIgs.getImageFeed());
        tv_nama.setText(accountIgs.getNama());
        tv_followers.setText(String.valueOf(accountIgs.getFollowers()));
        tv_following.setText(String.valueOf(accountIgs.getFollowing()));

        iv_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, PostinganActivity.class);
                intent.putExtra("accountIg", accountIgs);
                startActivity(intent);
            }
        });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, StoryActivity.class);
                intent.putExtra("accountIg", accountIgs);
                startActivity(intent);
            }
        });
    }
}