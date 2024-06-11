package com.example.praktikum_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class NoteActivity extends AppCompatActivity {

    Button btn_save;
    Intent intent;
    EditText titleInput, contentInput;
    Note note;
    User user;
    String title, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        btn_save = findViewById(R.id.save_note);
        titleInput = findViewById(R.id.title);
        contentInput = findViewById(R.id.content);

        btn_save.setOnClickListener( v -> {
            intent = new Intent(this, CardActivity.class);
            title = titleInput.getText().toString().trim();
            content = contentInput.getText().toString().trim();
            note = new Note(title, content);
            user = getIntent().getParcelableExtra("user");
            intent.putExtra("note", note);
            intent.putExtra("user", user);
            startActivity(intent);
        });
    }
}