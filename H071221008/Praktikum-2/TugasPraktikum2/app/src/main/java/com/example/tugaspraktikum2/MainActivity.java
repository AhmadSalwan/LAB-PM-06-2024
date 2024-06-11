package com.example.tugaspraktikum2;

import androidx.activity.EdgeToEdge;
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

    private EditText nama;
    private EditText uname;
    private ImageView getPict;
    private Button btnSubmit;

    private String textFromEt1;
    private String textFromEt2;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//variabel untuk hbgnkan ke elemen activity
        getPict = findViewById(R.id.getPict);
        nama = findViewById(R.id.nama);
        btnSubmit = findViewById(R.id.btnSubmit);
        uname = findViewById(R.id.uname);
//jadi btn untuk buka galeri
        getPict.setOnClickListener(view -> {
            Intent open = new Intent(Intent.ACTION_PICK);
            open.setType("image/*");
            launcherIntentGallery.launch(open);
        });

        btnSubmit.setOnClickListener(view -> {
            textFromEt1 = nama.getText().toString().trim();
            textFromEt2 = uname.getText().toString().trim();

            if (textFromEt1.isEmpty() || textFromEt2.isEmpty()) {
                Toast.makeText(this, "Isi semua field terlebih dahulu", Toast.LENGTH_SHORT).show();
            } else if (imageUri == null) {
                Toast.makeText(this, "Pilih gambar terlebih dahulu", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra("textFromEt1", textFromEt1);
                intent.putExtra("textFromEt2", textFromEt2);
                intent.putExtra("imageUri", imageUri.toString());
                startActivity(intent);
            }
        });
    }
    //untukgmbr
    ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        imageUri = data.getData();
                        getPict.setImageURI(imageUri);
                    }
                }
            });

}