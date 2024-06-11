package com.example.praktikum3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private ImageView iv_profile;
    private ImageView iv_story;
    private TextView tv_nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Menerima data dari intent
        Intent intent = getIntent();


        String nama = intent.getStringExtra("nama");
        String caption = intent.getStringExtra("caption");
        int imageProfile = intent.getIntExtra("imageprofile", 0);
        int imageStory = intent.getIntExtra("imagestory", 0);
        int imageFeed = intent.getIntExtra("imagefeed", 0);
        int followers = intent.getIntExtra("followers", 0);
        int following = intent.getIntExtra("following", 0);


        // Jika posisi valid, ambil data dari arraylist universitas


            // Inisialisasi views
            iv_profile = findViewById(R.id.iv_profile2);
            iv_story = findViewById(R.id.iv_story);
            tv_nama = findViewById(R.id.tv_nama2);

            iv_profile.setImageResource(imageProfile);
            iv_story.setImageResource(imageStory);
            tv_nama.setText(nama);

            // Set onClickListener untuk tv_nama
            tv_nama.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Membuat intent untuk memulai MainActivity3
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    // Menyertakan data yang ingin dikirim ke MainActivity3
                    intent.putExtra("nama", nama);
                    intent.putExtra("imageprofile", imageProfile);
                    intent.putExtra("imagefeed", imageFeed);
                    intent.putExtra("imagestory", imageStory);
                    intent.putExtra("followers", followers);
                    intent.putExtra("following", following);
                    intent.putExtra("caption", caption);
                    // Memulai MainActivity3
                    startActivity(intent);
                }
            });
        }
    }

