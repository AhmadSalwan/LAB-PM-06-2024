package com.example.tugaspraktikum2;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText title;
    private EditText content;
    private Button btnSave;

    private String textFromEt3;
    private String textFromEt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(view -> {
            textFromEt3 = title.getText().toString().trim();
            textFromEt4 = content.getText().toString().trim();

            if (textFromEt3.isEmpty() || textFromEt4.isEmpty()) {
                Toast.makeText(this, "Isi semua field terlebih dahulu", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, MainActivity3.class);
                // Meneruskan data ke MainActivity3
                intent.putExtra("textFromEt1", getIntent().getStringExtra("textFromEt1"));
                intent.putExtra("textFromEt2", getIntent().getStringExtra("textFromEt2"));
                intent.putExtra("textFromEt3", textFromEt3);
                intent.putExtra("textFromEt4", textFromEt4);
                // Meneruskan data gambar dari MainActivity
                intent.putExtra("imageUri", getIntent().getStringExtra("imageUri"));
                startActivity(intent);
            }
        });
    }

}
