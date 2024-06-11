package com.example.praktikum_2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity {

    Button btn_submit;
    ImageButton imageButton;
    Intent intent, galleryIntent;
    EditText nameEditText, usernameEditText;
    String name, username;
    Uri imageProfile;
    User user;

    private ActivityResultLauncher<Intent> galleryLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.imageButton);
        btn_submit = findViewById(R.id.submitForm);
        nameEditText = findViewById(R.id.name);
        usernameEditText= findViewById(R.id.username);

        imageButton.setOnClickListener( v -> {
            galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            galleryLauncher.launch(galleryIntent);
        });

        btn_submit.setOnClickListener( v -> {
            intent = new Intent(this, NoteActivity.class);
            name = nameEditText.getText().toString().trim();
            username = usernameEditText.getText().toString().trim();
            user = new User(name, username, imageProfile);
            if(user.getImageProfile() == null){
                Toast.makeText(this, "Please pick a profile image first!", Toast.LENGTH_SHORT).show();
                return;
            }else if (name.isEmpty() && user.getImageProfile() != null) {
                nameEditText.setError("Nama harus diisi");
                return;
            }else if (username.isEmpty() && user.getImageProfile() != null) {
                usernameEditText.setError("Username harus diisi");
                return;
            }
            intent.putExtra("user", user);
            startActivity(intent);
        });

        galleryLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        imageProfile = result.getData().getData();
                        Glide.with(this).load(imageProfile).into(imageButton);
                    }
                });
    }

}