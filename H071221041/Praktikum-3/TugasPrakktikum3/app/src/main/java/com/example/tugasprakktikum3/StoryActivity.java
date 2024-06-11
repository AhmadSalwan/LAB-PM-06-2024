package com.example.tugasprakktikum3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StoryActivity extends AppCompatActivity {

    private ImageView iv_profile;
    private ImageView iv_story;
    private TextView tv_nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();

        AccountIg accountIgs = intent.getParcelableExtra("accountIg");

        iv_profile = findViewById(R.id.iv_profile_story);
        iv_story = findViewById(R.id.imageStory);
        tv_nama = findViewById(R.id.tv_username_story);

        iv_profile.setImageResource(accountIgs.getImageProfile());
        iv_story.setImageResource(accountIgs.getImageStory());
        tv_nama.setText(accountIgs.getNama());

        tv_nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoryActivity.this, ProfileActivity.class);
                intent.putExtra("accountIg", accountIgs);
                startActivity(intent);
            }
        });
    }
}