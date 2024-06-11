package com.example.tugasprakktikum3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InstaFeedAdapter extends RecyclerView.Adapter<InstaFeedAdapter.ViewHolder> {

    private ArrayList<AccountIg> accountIg;

    public InstaFeedAdapter(ArrayList<AccountIg> accountIg){this.accountIg = accountIg;}

    @NonNull
    @Override
    public InstaFeedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.insta_feed, parent, false);
        return new InstaFeedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstaFeedAdapter.ViewHolder holder, int position) {
        AccountIg accountIgs = accountIg.get(position);

        holder.tv_username.setText(accountIgs.getNama());
        holder.ivProfile.setImageResource(accountIgs.getImageProfile());
        holder.ivFeed.setImageResource(accountIgs.getImageFeed());
        holder.tv_caption.setText(accountIgs.getCaption());

        holder.ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.context, StoryActivity.class);

                intent.putExtra("accountIg", accountIgs);
                holder.context.startActivity(intent);
            }
        });

        holder.tv_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Membuat intent
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                // Mengirim data melalui intent
                intent.putExtra("accountIg", accountIgs);

                holder.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return accountIg.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFeed, ivProfile;
        TextView tv_caption, tv_username;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFeed = itemView.findViewById(R.id.iv_feed);
            ivProfile = itemView.findViewById(R.id.iv_profile_feed);
            tv_username = itemView.findViewById(R.id.tv_username_feed);
            tv_caption = itemView.findViewById(R.id.tv_caption_feed);
            context = itemView.getContext();

        }
    }
}