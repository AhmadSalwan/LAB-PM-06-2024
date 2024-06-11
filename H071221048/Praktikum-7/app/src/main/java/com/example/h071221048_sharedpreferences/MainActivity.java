package com.example.h071221048_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button login, register;
    TextInputEditText nim, password;
    TextInputLayout lnim,lpassword;

    public static final int RESULT_CODE = 101;

     UserModel userModel;
     UserPreferences userprefs;
     String NIM, Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        userprefs = new UserPreferences(this);
        userModel = userprefs.getUser();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.main_login);
        register =findViewById(R.id.main_register);
        nim = findViewById(R.id.main_nim);
        password = findViewById(R.id.main_pw);
        lnim = findViewById(R.id.et_main_nim);
        lpassword = findViewById(R.id.et_main_password);
        nim.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    lnim.setHelperText(null);
                    lnim.setEndIconVisible(false);
                } else {

                }
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    lpassword.setHelperText(null);
                    lpassword.setEndIconVisible(false);
                } else {

                }
            }
        });
        isdarkMode();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NIM = nim.getText().toString().trim();
                Password = password.getText().toString().trim();
                if (TextUtils.isEmpty(NIM)) {
                    lnim.setEndIconVisible(true);
                    lnim.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
                    lnim.setEndIconDrawable(R.drawable.baseline_error_24);
                    lnim.setHelperText("Please Fill this section");
                    return;
                }
                if (TextUtils.isEmpty(Password)) {
                    lpassword.setEndIconVisible(true);
                    lpassword.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
                    lpassword.setEndIconDrawable(R.drawable.baseline_error_24);
                    lpassword.setHelperText("Please Fill this section");
                    return;
                }

                checkUser(NIM, Password);
            }
        });

    }

    private void checkUser(String nim, String password) {


        if (userModel == null) {
            Toast.makeText(this, "User not found. Please register.", Toast.LENGTH_SHORT).show();


        }else{

            if (!nim.equals(userprefs.getUser().getNim())) {
                Toast.makeText(this, "NIM Salah"+userprefs.getUser().getNim()+"NIM terinput:"+NIM, Toast.LENGTH_SHORT).show();

            } else if (!password.equals(userprefs.getUser().getPw())) {
                Toast.makeText(this, "Password Salah", Toast.LENGTH_SHORT).show();

            } else {
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
                finish();
            }
        }

    }
    public void isdarkMode(){
        if (userprefs.getUser().isDark()==true) {
            ConstraintLayout bgElement = findViewById(R.id.main_layout);
            int color = ContextCompat.getColor(MainActivity.this, R.color.dark);
            bgElement.setBackgroundColor(color);
            int colorText = ContextCompat.getColor(MainActivity.this, R.color.white);
            nim.setTextColor(colorText);
            password.setTextColor(colorText);
        } else if (userprefs.getUser().isDark()==false) {
            ConstraintLayout bgElement = findViewById(R.id.main_layout);
            int color = ContextCompat.getColor(MainActivity.this, R.color.white);
            int colorText = ContextCompat.getColor(MainActivity.this, R.color.dark);
            bgElement.setBackgroundColor(color);
            nim.setTextColor(colorText);
            password.setTextColor(colorText);
        }
    }

}