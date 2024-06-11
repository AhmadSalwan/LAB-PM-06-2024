package com.example.tugas3;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView storyRecyclerView, feedRecyclerView;
    private StoryAdapter storyAdapter;
    private FeedAdapter feedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi RecyclerView untuk cerita (story)
        storyRecyclerView = findViewById(R.id.storyRecyclerView);
        storyRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        // Inisialisasi adapter dan atur ke RecyclerView
        storyAdapter = new StoryAdapter(this, getStoryData());
        storyRecyclerView.setAdapter(storyAdapter);

        // Inisialisasi RecyclerView untuk konten beranda
        feedRecyclerView = findViewById(R.id.feedRecyclerView);
        feedRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Inisialisasi adapter dan atur ke RecyclerView
        feedAdapter = new FeedAdapter(this, getFeedData());
        feedRecyclerView.setAdapter(feedAdapter);
    }

    // Metode dummy untuk mendapatkan data cerita (story)
    private List<StoryModel> getStoryData() {
        List<StoryModel> storyList = new ArrayList<>();
        storyList.add(new StoryModel(R.drawable.mpl, "mpl.id.official"));
        storyList.add(new StoryModel(R.drawable.evos, "evosesport"));
        storyList.add(new StoryModel(R.drawable.rrq, "teamrrq"));
        storyList.add(new StoryModel(R.drawable.onic, "onic.esports"));
        storyList.add(new StoryModel(R.drawable.geek, "geekfamid"));
        storyList.add(new StoryModel(R.drawable.btr, "bigetronesports"));
        storyList.add(new StoryModel(R.drawable.blck, "blacklistintl"));
        storyList.add(new StoryModel(R.drawable.echo, "echophilippines"));
        storyList.add(new StoryModel(R.drawable.aura, "auraesports"));
        storyList.add(new StoryModel(R.drawable.alterego, "alteregoesports"));
        return storyList;
    }

    private List<FeedModel> getFeedData() {
        List<FeedModel> feedList = new ArrayList<>();
        feedList.add(new FeedModel(R.drawable.mpl, R.drawable.feed_mpl, "mpl.id.official"));
        feedList.add(new FeedModel(R.drawable.evos, R.drawable.feed_evos, "evosesport"));
        feedList.add(new FeedModel(R.drawable.rrq, R.drawable.feed_rrq, "teamrrq"));
        feedList.add(new FeedModel(R.drawable.onic, R.drawable.feed_onic, "onic.esports"));
        feedList.add(new FeedModel(R.drawable.geek, R.drawable.feed_geek, "geekfamid"));
        feedList.add(new FeedModel(R.drawable.btr, R.drawable.feed_btr, "bigetronesports"));
        feedList.add(new FeedModel(R.drawable.blck, R.drawable.feed_blck, "blacklistintl"));
        feedList.add(new FeedModel(R.drawable.echo, R.drawable.feed_echo, "echophilippines"));
        feedList.add(new FeedModel(R.drawable.aura, R.drawable.feed_aura, "auraesports"));
        feedList.add(new FeedModel(R.drawable.alterego, R.drawable.feed_alterego, "alteregoesports"));
        return feedList;
    }
}


