package com.example.h071221048_andiahmadsalwan_tugas5_thread;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Profile extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_profile, container, false);
        String[] name= getResources().getStringArray(R.array.MyProfile);
        TextView profile_name=view.findViewById(R.id.profileName);
        TextView profile_desc=view.findViewById(R.id.profileBio);
        profile_name.setText(name[0]);
        profile_desc.setText(name[1]);
        return view;

    }
}