package com.example.h071221048_sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {
    private static final String PREFS_NAME="user_pref";
    private static final String PW="pw";
    private static final String NIM="nim";
    private static final String DARKMODE="isdark";

    private final SharedPreferences sharedPreferences;

    public UserPreferences(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
    }

    public void setUser(UserModel value){
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(PW,value.pw);
        editor.putString(NIM,value.nim);
        editor.putBoolean(DARKMODE,value.isDark);
        editor.apply();
    }
     UserModel getUser(){
        UserModel model=new UserModel();
        model.setPw(sharedPreferences.getString(PW,""));
        model.setNim(sharedPreferences.getString(NIM,""));
        model.setDark(sharedPreferences.getBoolean(DARKMODE,false));
        return model;
    }

    public void resetUser() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
