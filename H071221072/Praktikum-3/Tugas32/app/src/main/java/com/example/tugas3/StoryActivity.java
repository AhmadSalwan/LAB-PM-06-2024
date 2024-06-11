package com.example.tugas3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        ImageView ivLogo = findViewById(R.id.iv_logo);
        ImageView ivStory = findViewById(R.id.iv_story);
        TextView tvUsername = findViewById(R.id.tv_username);

        Intent intent = getIntent();

        int gambarStory = intent.getIntExtra("STORY_DEFAULT",0);
        int gambarAkun = intent.getIntExtra("GAMBAR_DEFAULT", 0);
        String username = intent.getStringExtra("USERNAME_DEFAULT");

        ivLogo.setImageResource(gambarAkun);
        ivStory.setImageResource(gambarStory);
        tvUsername.setText(username);
    }
}