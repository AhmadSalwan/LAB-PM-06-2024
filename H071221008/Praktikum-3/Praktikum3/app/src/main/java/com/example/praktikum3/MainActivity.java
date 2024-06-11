package com.example.praktikum3;

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
        rv_feed = findViewById(R.id.rv_feed);

        rv_story.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_feed.setLayoutManager(new GridLayoutManager(this, 1));
        rv_story.setHasFixedSize(true);
        rv_feed.setHasFixedSize(true);

        StoryAdapter storyAdapter = new StoryAdapter(DataSource.artis);
        rv_story.setAdapter(storyAdapter);

        FeedAdapter feedAdapter = new FeedAdapter(DataSource.artis);
        rv_feed.setAdapter(feedAdapter);
    }
}