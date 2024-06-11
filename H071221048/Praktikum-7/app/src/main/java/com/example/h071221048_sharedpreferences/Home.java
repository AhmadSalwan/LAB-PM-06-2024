package com.example.h071221048_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    UserPreferences userPreferences;
    UserModel userModel;
    private Button logout,setting;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userPreferences = new UserPreferences(this);
        userModel = userPreferences.getUser();
        setContentView(R.layout.activity_home);
        title=findViewById(R.id.home_welcome);
        logout=findViewById(R.id.home_logout);
        setting=findViewById(R.id.home_edit);
        title.setText("Welcome "+userPreferences.getUser().getNim());
        title.setGravity(Gravity.CENTER_HORIZONTAL);
        isdarkMode();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,MainActivity.class);
                userPreferences.resetUser();
                startActivity(intent);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Settings.class);
                startActivity(intent);
            }
        });
    }
    public void isdarkMode(){
        if (userPreferences.getUser().isDark()==true) {
            ConstraintLayout bgElement = findViewById(R.id.home_layout);
            int color = ContextCompat.getColor(Home.this, R.color.dark);
            int colorText = ContextCompat.getColor(Home.this, R.color.white);
            bgElement.setBackgroundColor(color);
            title.setTextColor(colorText);
            Toast.makeText(Home.this, String.valueOf(userPreferences.getUser().isDark()), Toast.LENGTH_SHORT).show();
        } else if (userPreferences.getUser().isDark()==false) {
            ConstraintLayout bgElement = findViewById(R.id.home_layout);
            int color = ContextCompat.getColor(Home.this, R.color.white);
            int colorText = ContextCompat.getColor(Home.this, R.color.dark);
            bgElement.setBackgroundColor(color);

            title.setTextColor(colorText);
            Toast.makeText(Home.this, String.valueOf(userPreferences.getUser().isDark()), Toast.LENGTH_SHORT).show();
        }
    }
}