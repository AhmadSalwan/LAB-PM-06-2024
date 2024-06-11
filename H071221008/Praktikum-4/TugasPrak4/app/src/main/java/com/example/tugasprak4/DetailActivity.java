package com.example.tugasprak4;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.example.tugasprak4.ProfileFragment;

public class DetailActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        DetailActivity.super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        FragmentManager fragmentManager = getSupportFragmentManager();
        ProfileFragment profileFragment = new ProfileFragment();
        Intent getExtra = getIntent();
        if (getExtra != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(ProfileFragment.EXTRA_USER, getExtra.getParcelableExtra(ProfileFragment.EXTRA_USER));
            profileFragment.setArguments(bundle);
        }
        fragmentManager.beginTransaction().add(R.id.my_frame_layout, profileFragment, ProfileFragment.class.getSimpleName()).commit();
    }
}