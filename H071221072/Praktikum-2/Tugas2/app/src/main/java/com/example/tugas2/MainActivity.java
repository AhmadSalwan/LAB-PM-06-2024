package com.example.tugas2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    Uri imageUri;

    private Button button;

    private ImageView imageView;

    private EditText edittext1;

    private EditText edittext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonsubmit);
        imageView = findViewById(R.id.iv);
        edittext1 = findViewById(R.id.textnama);
        edittext2 = findViewById(R.id.textusername);


        imageView.setOnClickListener(view -> {
            Intent openGallery = new Intent(Intent.ACTION_PICK);
            openGallery.setType("image/*");
            launcherIntentGallery.launch(openGallery);

        });

        button.setOnClickListener(view -> {
            String editTextValue = edittext1.getText().toString();
            String editTextValue2 = edittext2.getText().toString();
            Intent intent = new Intent(this,MainActivity2.class);
            intent.putExtra("name1", editTextValue);
            intent.putExtra("username1", editTextValue2);
            intent.putExtra("image", imageUri.toString());
            startActivity(intent);
        });
    }

    ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    imageUri = data.getData();
                    imageView.setImageURI(imageUri);
                }
            }
    );
}