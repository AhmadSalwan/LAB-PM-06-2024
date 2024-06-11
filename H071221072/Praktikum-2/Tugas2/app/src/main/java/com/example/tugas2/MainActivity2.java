package com.example.tugas2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Uri imageUri;

    private Button button;

    private EditText et1;

    private EditText et2;

    private ImageView imageView;

    private String et3;

    private String et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.buttonsave);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        String name1 = getIntent().getStringExtra("name1");
        String username1 = getIntent().getStringExtra("username1");
        String image = getIntent().getStringExtra("image");

        button.setOnClickListener(view -> {
            String editnote = et1.getText().toString();
            String editnote2 = et2.getText().toString();
            Intent intent = new Intent(this,MainActivity3.class);
            intent.putExtra("note1", editnote);
            intent.putExtra("note2", editnote2);
            intent.putExtra("name1", name1);
            intent.putExtra("username1", username1);
            intent.putExtra("imageUri", image);
            startActivity(intent);
        });

    }
}