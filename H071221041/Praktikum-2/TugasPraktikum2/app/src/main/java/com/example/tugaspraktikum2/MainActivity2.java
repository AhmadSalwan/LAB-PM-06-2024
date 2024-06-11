package com.example.tugaspraktikum2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText etTitle;
    private EditText etContent;
    private Button btnSave;
    private String textFromEtTitle;
    private String textFromEtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etTitle = findViewById(R.id.title);
        etContent = findViewById(R.id.content);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(view -> {
            textFromEtTitle = etTitle.getText().toString().trim();
            textFromEtContent = etContent.getText().toString().trim();

            if (textFromEtTitle.isEmpty() || textFromEtContent.isEmpty()) {
                Toast.makeText(this, "Fill in all fields first", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, MainActivity3.class);

                intent.putExtra("textFromEtNama", getIntent().getStringExtra("textFromEtNama"));
                intent.putExtra("textFromEtUname", getIntent().getStringExtra("textFromEtUname"));
                intent.putExtra("textFromEtTitle", textFromEtTitle);
                intent.putExtra("textFromEtContent", textFromEtContent);
                intent.putExtra("imageUri", getIntent().getStringExtra("imageUri"));
                startActivity(intent);
            }
        });
    }
}