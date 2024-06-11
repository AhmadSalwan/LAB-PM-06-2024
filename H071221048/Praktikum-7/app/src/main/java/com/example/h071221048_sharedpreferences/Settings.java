package com.example.h071221048_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
     private UserModel userModel;
     UserPreferences user;

    Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        aSwitch=findViewById(R.id.switch1);
        user = new UserPreferences(this);
        userModel =user.getUser();
        isdarkMode();
        if(isdarkMode()==true){
            aSwitch.setChecked(true);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(aSwitch.isChecked()){
                user.getUser().getNim();
                user.getUser().getPw();
                userModel.setDark(true);
                user.setUser(userModel);
                isdarkMode();
            } else if (!aSwitch.isChecked()) {
                    user.getUser().getNim();
                    user.getUser().getPw();
                    userModel.setDark(false);
                    user.setUser(userModel);
                    isdarkMode();
                }
            }
        });


    }   public boolean isdarkMode(){
        if (user.getUser().isDark()==true) {
            ConstraintLayout bgElement = findViewById(R.id.setting_layout);
            int color = ContextCompat.getColor(Settings.this, R.color.dark);
            int colorText = ContextCompat.getColor(Settings.this, R.color.white);
            bgElement.setBackgroundColor(color);
            aSwitch.setTextColor(colorText);
            Toast.makeText(Settings.this, String.valueOf(user.getUser().isDark()), Toast.LENGTH_SHORT).show();

            return true;
        } else if (user.getUser().isDark()==false) {
            ConstraintLayout bgElement = findViewById(R.id.setting_layout);
            int color = ContextCompat.getColor(Settings.this, R.color.white);
            int colorText = ContextCompat.getColor(Settings.this, R.color.dark);
            bgElement.setBackgroundColor(color);
            aSwitch.setTextColor(colorText);
            Toast.makeText(Settings.this, String.valueOf(user.getUser().isDark()), Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Settings.this,Home.class);
        startActivity(intent);
    }
}