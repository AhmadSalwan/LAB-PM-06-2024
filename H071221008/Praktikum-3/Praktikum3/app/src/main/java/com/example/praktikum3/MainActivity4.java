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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity4 extends AppCompatActivity {

    private ImageView iv_profile;
    private ImageView iv_feed;
    private TextView tv_nama, tv_caption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        Intent intent = getIntent();

        String nama = intent.getStringExtra("nama");
        String caption = intent.getStringExtra("caption");
        int imageProfile = intent.getIntExtra("imageprofile", 0);
        int imageFeed = intent.getIntExtra("imagefeed", 0);
        int imageStory = intent.getIntExtra("imagestory", 0);
        int followers = intent.getIntExtra("followers", 0);
        int following = intent.getIntExtra("following", 0);

        iv_profile = findViewById(R.id.iv_profile4);
        iv_feed = findViewById(R.id.iv_feed3);
        tv_nama = findViewById(R.id.tv_namaprofile);
        tv_caption = findViewById(R.id.tv_caption2);


        iv_profile.setImageResource(imageProfile);
        iv_feed.setImageResource(imageFeed);
        tv_nama.setText(nama);
        tv_caption.setText(String.valueOf(caption));

        tv_nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat intent untuk memulai MainActivity3
                Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
                // Menyertakan data yang ingin dikirim ke MainActivity3
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
                // Membuat intent untuk memulai MainActivity3
                Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
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