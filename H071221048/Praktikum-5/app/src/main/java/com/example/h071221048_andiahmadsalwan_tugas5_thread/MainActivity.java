package com.example.h071221048_andiahmadsalwan_tugas5_thread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{
    BottomNavigationView bottomNavigationView;
    public  static boolean firstLeft=true;

    public static boolean isFirstLeft() {
        return firstLeft;
    }
    public static void setFirstLeft(boolean firstLeft) {
        MainActivity.firstLeft = firstLeft;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomnavigation);
        bottomNavigationView.setSelectedItemId(R.id.buttonHome);
        replaceFragment(new Home());
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId()==R.id.buttonAdd){
                replaceFragment(new Add());
            } else if (item.getItemId()==R.id.buttonHome){
                replaceFragment(new Home());
            } else if (item.getItemId()==R.id.buttonSearch) {
                replaceFragment(new Search());
            } else if (item.getItemId()==R.id.buttonProfile) {
                replaceFragment(new Profile());
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void showFull(int position) {

    }
}