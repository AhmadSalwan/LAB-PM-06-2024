package com.example.h071221048_andi_ahmad_salwan_tugas6_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FullView extends AppCompatActivity {
    TextView name,useremail;
    ImageView image;

    private Handler handler = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);

        name=findViewById(R.id.tv_namefullview);
        useremail=findViewById(R.id.tv_emailfullview);
        image=findViewById(R.id.iv_fullview);
        ProgressBar spinner=findViewById(R.id.progressBar2);
        String fullname=getIntent().getStringExtra("name");
        String img=getIntent().getStringExtra("img");
        String email=getIntent().getStringExtra("email");


        name.setText(fullname);
        useremail.setText(email);
        Picasso.get().load(img).into(image);
        name.setVisibility(View.INVISIBLE);
        useremail.setVisibility(View.INVISIBLE);
        image.setVisibility(View.INVISIBLE);
        handler.postDelayed(() -> {
            spinner.setVisibility(View.INVISIBLE);
            name.setVisibility(View.VISIBLE);
            useremail.setVisibility(View.VISIBLE);
            image.setVisibility(View.VISIBLE);
        }, 800);

    }
}