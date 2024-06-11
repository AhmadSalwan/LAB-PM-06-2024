package com.example.tugasprakktikum3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PostinganActivity extends AppCompatActivity {

    private ImageView iv_profile;
    private ImageView iv_feed;
    private TextView tv_nama, tv_caption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_postingan);

        Intent intent = getIntent();

        AccountIg accountIgs = intent.getParcelableExtra("accountIg");


        iv_profile = findViewById(R.id.iv_profile_post);
        iv_feed = findViewById(R.id.iv_postingan_post);
        tv_nama = findViewById(R.id.tv_username_post);
        tv_caption = findViewById(R.id.tv_caption_post);


        iv_profile.setImageResource(accountIgs.getImageProfile());
        iv_feed.setImageResource(accountIgs.getImageFeed());
        tv_nama.setText(accountIgs.getNama());
        tv_caption.setText(String.valueOf(accountIgs.getCaption()));

        tv_nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostinganActivity.this, ProfileActivity.class);
                intent.putExtra("accountIg", accountIgs);
                startActivity(intent);
            }
        });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostinganActivity.this, StoryActivity.class);
                intent.putExtra("accountIg", accountIgs);
                startActivity(intent);
            }
        });
    }
}