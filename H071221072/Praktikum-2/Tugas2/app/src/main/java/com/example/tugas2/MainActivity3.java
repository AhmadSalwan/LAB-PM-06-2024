package com.example.tugas2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private Uri imageuri;

    private ImageView imageView;

    private TextView textname1;

    private TextView note1;

    private TextView textusername1;

    private TextView note2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        textname1 = findViewById(R.id.textname1);
        note1 = findViewById(R.id.textname2);
        textusername1 = findViewById(R.id.textusername1);
        note2 = findViewById(R.id.textusername2);
        imageView = findViewById(R.id.iv);

        String name1 = getIntent().getStringExtra("name1");
        String textnote1 = getIntent().getStringExtra("note1");
        String username1 = getIntent().getStringExtra("username1");
        String textnote2 = getIntent().getStringExtra("note2");
        String imageValue = getIntent().getStringExtra("imageUri");
        Uri imageUri = Uri.parse(imageValue);

        imageView.setImageURI(imageUri);
        textname1.setText(name1);
        textusername1.setText(username1);
        note1.setText(textnote1);
        note2.setText(textnote2);
    }
}