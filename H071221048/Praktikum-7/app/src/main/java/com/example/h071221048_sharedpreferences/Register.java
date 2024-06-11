package com.example.h071221048_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {
    TextInputEditText nim, password;
    TextInputLayout lnim,lpassword;
    Button submit;
    String NIM,Password;

    UserPreferences userPreferences;
    UserModel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        userPreferences = new UserPreferences(Register.this);
        user = userPreferences.getUser();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nim = findViewById(R.id.register_nim);
        password = findViewById(R.id.register_password);
        lnim = findViewById(R.id.et_register_nim);
        lpassword = findViewById(R.id.et_register_password);
        submit = findViewById(R.id.register_submit);
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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NIM = nim.getText().toString().trim();
                Password = password.getText().toString().trim();
                if (TextUtils.isEmpty(NIM) || TextUtils.isEmpty(Password)) {
                    if (TextUtils.isEmpty(NIM)) {
                        lnim.setEndIconVisible(true);
                        lnim.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
                        lnim.setEndIconDrawable(R.drawable.baseline_error_24);
                        lnim.setHelperText("Please Fill this section");

                    }
                    else if (TextUtils.isEmpty(Password)) {
                        lpassword.setEndIconVisible(true);
                        lpassword.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
                        lpassword.setEndIconDrawable(R.drawable.baseline_error_24);
                        lpassword.setHelperText("Please Fill this section");

                    }
                } else {


                    userPreferences.resetUser();
                    user.setNim(nim.getText().toString());
                    user.setPw(password.getText().toString());
                    user.setDark(false);
                    userPreferences.setUser(user);
                    finish();
                }
            }
        });

    }

    public void isdarkMode() {
        if (userPreferences.getUser().isDark() == true) {
            ConstraintLayout bgElement = findViewById(R.id.register_layout);
            int color = ContextCompat.getColor(Register.this, R.color.dark);
            int colorText = ContextCompat.getColor(Register.this, R.color.white);
            bgElement.setBackgroundColor(color);
            nim.setTextColor(colorText);
            password.setTextColor(colorText);

        } else if (userPreferences.getUser().isDark() == false) {
            ConstraintLayout bgElement = findViewById(R.id.register_layout);
            int color = ContextCompat.getColor(Register.this, R.color.white);
            int colorText = ContextCompat.getColor(Register.this, R.color.dark);
            bgElement.setBackgroundColor(color);
            nim.setTextColor(colorText);
            password.setTextColor(colorText);

        }
    }
}