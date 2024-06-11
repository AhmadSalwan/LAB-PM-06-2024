package com.example.tugas1praktikum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText text1;
    Button button1;
    ListView listview2;

    ArrayList<String> text_list;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.text1);
        button1 = findViewById(R.id.button1);
        listview2 = findViewById(R.id.listview2);
        text_list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, text_list);
        listview2.setAdapter(adapter);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = text1.getText().toString().trim();
                if (!text.isEmpty()){
                    text_list.add(text);
                    adapter.notifyDataSetChanged();
                    text1.setText("");
                }
            }
        });
    }
}