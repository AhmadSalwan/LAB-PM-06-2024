package com.example.tugas3;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private Context context;
    private List<StoryModel> storyList;

    public StoryAdapter(Context context, List<StoryModel> storyList) {
        this.context = context;
        this.storyList = storyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoryModel story = storyList.get(position);
        holder.storyImageView.setImageResource(story.getImageResource());
        holder.usernameTextView.setText(story.getUsername());
        holder.parentlayout.setOnClickListener(view -> {
            if (story.getUsername().equals("mpl.id.official")) {
                Intent intent = new Intent(context, StoryActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.mpl);
                intent.putExtra("STORY_DEFAULT", R.drawable.story_mpl);
                intent.putExtra("USERNAME_DEFAULT", "mpl.id.official");
                context.startActivity(intent);
            }
            if (story.getUsername().equals("evosesport")) {
            if (story.getUsername().equals("evosesport")) {
                Intent intent = new Intent(context, StoryActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.evos);
                intent.putExtra("STORY_DEFAULT",R.drawable.story_evos);
                intent.putExtra("USERNAME_DEFAULT", "evosesport");
                context.startActivity(intent);
            }
            if (story.getUsername().equals("teamrrq")) {
                Intent intent = new Intent(context, StoryActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.rrq);
                intent.putExtra("STORY_DEFAULT",R.drawable.story_rrq);
                intent.putExtra("USERNAME_DEFAULT", "teamrrq");
                context.startActivity(intent);
            }if (story.getUsername().equals("onic.esports")) {
                Intent intent = new Intent(context, StoryActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.onic);
                intent.putExtra("STORY_DEFAULT",R.drawable.story_onic);
                intent.putExtra("USERNAME_DEFAULT", "onic.esports");
                context.startActivity(intent);
            }if (story.getUsername().equals("geekfamid")) {
                Intent intent = new Intent(context, StoryActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.geek);
                intent.putExtra("STORY_DEFAULT",R.drawable.story_geek);
                intent.putExtra("USERNAME_DEFAULT", "geekfamid");
                context.startActivity(intent);
            }if (story.getUsername().equals("bigetronesports")) {
                Intent intent = new Intent(context, StoryActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.btr);
                intent.putExtra("STORY_DEFAULT",R.drawable.story_btr);
                intent.putExtra("USERNAME_DEFAULT", "bigetronesports");
                context.startActivity(intent);
            }if (story.getUsername().equals("blacklistintl")) {
                Intent intent = new Intent(context, StoryActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.blck);
                intent.putExtra("STORY_DEFAULT",R.drawable.story_blck);
                intent.putExtra("USERNAME_DEFAULT", "blacklistintl");
                context.startActivity(intent);
            }if (story.getUsername().equals("echophilippines")) {
                Intent intent = new Intent(context, StoryActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.echo);
                intent.putExtra("STORY_DEFAULT",R.drawable.story_echo);
                intent.putExtra("USERNAME_DEFAULT", "echophilippines");
                context.startActivity(intent);
            }if (story.getUsername().equals("auraesports")) {
                Intent intent = new Intent(context, StoryActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.aura);
                intent.putExtra("STORY_DEFAULT",R.drawable.story_aura);
                intent.putExtra("USERNAME_DEFAULT", "auraesports");
                context.startActivity(intent);
            }if (story.getUsername().equals("alteregoesports")) {
                Intent intent = new Intent(context, StoryActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.alterego);
                intent.putExtra("STORY_DEFAULT",R.drawable.story_alterego);
                intent.putExtra("USERNAME_DEFAULT", "alteregoesports");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView storyImageView;
        TextView usernameTextView;
        LinearLayout parentlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            storyImageView = itemView.findViewById(R.id.storyImageView);
            usernameTextView = itemView.findViewById(R.id.usernameTextView);
            parentlayout = itemView.findViewById(R.id.parentlayout);
        }
    }
}


