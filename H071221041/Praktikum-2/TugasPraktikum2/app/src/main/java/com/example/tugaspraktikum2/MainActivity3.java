package com.example.tugaspraktikum2;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private TextView textViewNama;
    private TextView textViewUname;
    private TextView textViewTitle;
    private TextView textViewContent;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        image = findViewById(R.id.image);
        textViewNama = findViewById(R.id.textNama);
        textViewUname = findViewById(R.id.textUname);
        textViewTitle = findViewById(R.id.textTitle);
        textViewContent = findViewById(R.id.textContent);

        String imageUriString = getIntent().getStringExtra("imageUri");
        String textNama = getIntent().getStringExtra("textFromEtNama");
        String textUname = getIntent().getStringExtra("textFromEtUname");
        String textTitle = getIntent().getStringExtra("textFromEtTitle");
        String textContent = getIntent().getStringExtra("textFromEtContent");


        Uri imageUri = Uri.parse(imageUriString);
        image.setImageURI(imageUri);
        textViewNama.setText(textNama);
        textViewUname.setText(textUname);
        textViewTitle.setText(textTitle);
        textViewContent.setText(textContent);
    }
}