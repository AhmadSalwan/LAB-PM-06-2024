package com.example.praktikum3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private ImageView iv_profile;
    private ImageView iv_feed;
    private TextView tv_nama, tv_followers, tv_following;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();

        // Mengambil data yang dikirim dari MainActivity2
        String nama = intent.getStringExtra("nama");
        String caption = intent.getStringExtra("caption");
        int imageProfile = intent.getIntExtra("imageprofile", 0);
        int imageStory = intent.getIntExtra("imagestory", 0);
        int imageFeed = intent.getIntExtra("imagefeed", 0);
        int followers = intent.getIntExtra("followers", 0);
        int following = intent.getIntExtra("following", 0);

        // Inisialisasi views
        iv_profile = findViewById(R.id.iv_profile3);
        iv_feed = findViewById(R.id.iv_feed2);
        tv_nama = findViewById(R.id.tv_nama3);
        tv_followers = findViewById(R.id.tv_followers);
        tv_following = findViewById(R.id.tv_following);

        // Menampilkan data universitas pada views
        iv_profile.setImageResource(imageProfile);
        iv_feed.setImageResource(imageFeed);
        tv_nama.setText(nama);
        tv_followers.setText(String.valueOf(followers));
        tv_following.setText(String.valueOf(following));

            iv_feed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                    intent.putExtra("nama", nama);
                    intent.putExtra("imageprofile", imageProfile);
                    intent.putExtra("imagefeed", imageFeed);
                    intent.putExtra("imagestory", imageStory);
                    intent.putExtra("followers", followers);
                    intent.putExtra("following", following);
                    intent.putExtra("caption", caption);
                    startActivity(intent);
                }
            });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                intent.putExtra("nama", nama);
                intent.putExtra("imageprofile", imageProfile);
                intent.putExtra("imagefeed", imageFeed);
                intent.putExtra("imagestory", imageStory);
                intent.putExtra("followers", followers);
                intent.putExtra("following", following);
                intent.putExtra("caption", caption);
                startActivity(intent);
            }
        });
        }
    }
