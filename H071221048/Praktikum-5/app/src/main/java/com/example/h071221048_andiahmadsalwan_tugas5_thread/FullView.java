package com.example.h071221048_andiahmadsalwan_tugas5_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FullView extends AppCompatActivity {
    TextView tv_name,tv_decs;
    ImageView iv_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);

        tv_name=findViewById(R.id.tv_detailName);
        tv_decs=findViewById(R.id.tv_detailComment);
        iv_image=findViewById(R.id.iv_detailImage);

        String name=getIntent().getStringExtra("name");
        String comment=getIntent().getStringExtra("comment");
        try {
        int img=getIntent().getIntExtra("img",0);
        iv_image.setImageResource(img);
        }catch (NullPointerException e){};

        try {

            String imageString= getIntent().getStringExtra("image");
            Uri image=Uri.parse(imageString);
            iv_image.setImageURI(image);
        }catch (NullPointerException e){};


        tv_name.setText(name);
        tv_decs.setText(comment);
    }
}