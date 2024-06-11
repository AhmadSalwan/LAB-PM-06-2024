package com.example.praktikum_2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class CardActivity extends AppCompatActivity {

    ImageView imageUser;
    TextView name, username, title, content;
    User user;
    Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        imageUser = findViewById(R.id.imageUser);
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);

        user = getIntent().getParcelableExtra("user");
        note = getIntent().getParcelableExtra("note");

        Glide.with(this)
                .load(user.getImageProfile())
                .into(imageUser);

        name.setText(user.getName());
        username.setText(user.getUsername());
        title.setText(note.getTitle());
        content.setText(note.getContent());
    }
}
