package com.example.tugasprak4;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();
    private ImageView homeIconMenuIv;
    private TextView homeTextMenuTv;
    private LinearLayout homeLayout;
    private LinearLayout postingLayout;
    private LinearLayout profileLayout;
    private ImageView postIconMenuIv;
    private TextView postTextMenuTv;
    private ImageView profileIconMenuIv;
    private TextView profileTextMenuTv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        HomeFragment homeFragment = new HomeFragment();
        if (!(this.fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName()) instanceof HomeFragment)) {
            this.fragmentManager.beginTransaction().replace(R.id.frame_layout, homeFragment, HomeFragment.class.getSimpleName()).commit();
        }
        this.homeLayout.setOnClickListener(new MainActivity2(this));
        this.postingLayout.setOnClickListener(new MainActivity3(this));
        this.profileLayout.setOnClickListener(new MainActivity4(this));
    }

    public void MainActivity2 (View v) {
        onClickMenu(this.homeLayout);
    }

    public void MainActivity3 (View v) {
        onClickMenu(this.postingLayout);
    }

    public void MainActivity4 (View v) {
        onClickMenu(this.profileLayout);
    }

    public void isActiveHomeMenu(boolean isActive) {
        if (isActive) {
            this.homeIconMenuIv.setColorFilter(ContextCompat.getColor(this, R.color.primaryColor));
            this.homeTextMenuTv.setTextColor(ContextCompat.getColor(this, R.color.primaryColor));
            return;
        }
        this.homeIconMenuIv.setColorFilter(ContextCompat.getColor(this, R.color.dividerColor));
        this.homeTextMenuTv.setTextColor(ContextCompat.getColor(this, R.color.dividerColor));
    }

    public void isActivePostMenu(boolean isActive) {
        if (isActive) {
            this.postIconMenuIv.setColorFilter(ContextCompat.getColor(this, R.color.primaryColor));
            this.postTextMenuTv.setTextColor(ContextCompat.getColor(this, R.color.primaryColor));
            return;
        }
        this.postIconMenuIv.setColorFilter(ContextCompat.getColor(this, R.color.dividerColor));
        this.postTextMenuTv.setTextColor(ContextCompat.getColor(this, R.color.dividerColor));
    }

    public void isActiveProfileMenu(boolean isActive) {
        if (isActive) {
            this.profileIconMenuIv.setColorFilter(ContextCompat.getColor(this, R.color.primaryColor));
            this.profileTextMenuTv.setTextColor(ContextCompat.getColor(this, R.color.primaryColor));
            return;
        }
        this.profileIconMenuIv.setColorFilter(ContextCompat.getColor(this, R.color.dividerColor));
        this.profileTextMenuTv.setTextColor(ContextCompat.getColor(this, R.color.dividerColor));
    }

    private void onClickMenu(LinearLayout linearLayout) {
        Fragment selectedFragment = new Fragment();
        String fragmentName = "";
        if (linearLayout == this.homeLayout) {
            selectedFragment = new HomeFragment();
            fragmentName = HomeFragment.class.getSimpleName();
            isActiveHomeMenu(true);
            isActivePostMenu(false);
            isActiveProfileMenu(false);
        }
        if (linearLayout == this.postingLayout) {
            selectedFragment = new PostFragment();
            fragmentName = PostFragment.class.getSimpleName();
            isActiveHomeMenu(false);
            isActivePostMenu(true);
            isActiveProfileMenu(false);
        }
        if (linearLayout == this.profileLayout) {
            selectedFragment = new ProfileFragment();
            fragmentName = ProfileFragment.class.getSimpleName();
            isActiveHomeMenu(false);
            isActivePostMenu(false);
            isActiveProfileMenu(true);
        }
        if (this.fragmentManager.findFragmentByTag(fragmentName) == null) {
            this.fragmentManager.beginTransaction().replace(R.id.frame_layout, selectedFragment, fragmentName).commit();
        }
    }

    private void initView() {
        this.homeIconMenuIv = findViewById(R.id.home_icon);
        this.homeTextMenuTv = findViewById(R.id.home_text);
        this.postIconMenuIv = findViewById(R.id.posting_icon);
        this.postTextMenuTv = findViewById(R.id.posting_text);
        this.profileIconMenuIv = findViewById(R.id.profile_icon);
        this.profileTextMenuTv = findViewById(R.id.profile_text);
        this.homeLayout = findViewById(R.id.home_layout);
        this.postingLayout = findViewById(R.id.posting_layout);
        this.profileLayout = findViewById(R.id.profile_layout);

        isActiveHomeMenu(true);
        isActivePostMenu(false);
        isActiveProfileMenu(false);
    }
}
