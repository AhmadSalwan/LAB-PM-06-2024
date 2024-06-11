package com.example.tugaspraktikum2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNama;
    private EditText etUname;
    private ImageView image;
    private Button btnSubmit;

    private String textFromEtNama;
    private String textFromEtUname;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.nama);
        etUname = findViewById(R.id.uname);
        image = findViewById(R.id.getPict);
        btnSubmit = findViewById(R.id.btnSubmit);

        image.setOnClickListener(view -> {
            Intent open = new Intent(Intent.ACTION_PICK);
            open.setType("image/*");
            launcherIntentGallery.launch(open);
        });

        btnSubmit.setOnClickListener(view -> {
            textFromEtNama = etNama.getText().toString().trim();
            textFromEtUname = etUname.getText().toString().trim();
9
            if (textFromEtNama.isEmpty() || textFromEtUname.isEmpty()) {
                Toast.makeText(this, "Fill in all fields first", Toast.LENGTH_SHORT).show();
            } else if (imageUri == null) {
                Toast.makeText(this, "Please pick a profile image first", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra("textFromEtNama", textFromEtNama);
                intent.putExtra("textFromEtUname", textFromEtUname);
                intent.putExtra("imageUri", imageUri.toString());
                startActivity(intent);
            }
        });
    }
    ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        imageUri = data.getData();
                        image.setImageURI(imageUri);
                    }
                }
            });
}