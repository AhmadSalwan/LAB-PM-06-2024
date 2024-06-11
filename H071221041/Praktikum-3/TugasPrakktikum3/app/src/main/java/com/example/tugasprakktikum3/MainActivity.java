package com.example.tugasprakktikum3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_story;
    private RecyclerView rv_feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rv_story = findViewById(R.id.rv_story);
        rv_story.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_story.setHasFixedSize(true);
        StoryAdapter storyAdapter = new StoryAdapter(DataSources.accountIg);
        rv_story.setAdapter(storyAdapter);

        rv_feed = findViewById(R.id.rv_feed);
        rv_feed.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_feed.setHasFixedSize(true);
        InstaFeedAdapter instaFeedAdapter = new InstaFeedAdapter(DataSources.accountIg);
        rv_feed.setAdapter(instaFeedAdapter);
    }
}
