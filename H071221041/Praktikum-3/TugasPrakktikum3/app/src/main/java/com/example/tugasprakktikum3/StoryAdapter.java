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

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private ArrayList<AccountIg> accountIgs;

    public StoryAdapter(ArrayList<AccountIg> accountIgs) {
        this.accountIgs = accountIgs;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        AccountIg accountIg = accountIgs.get(position);

        holder.ivStoryProfile.setImageResource(accountIg.getImageProfile());
        holder.tv_name.setText(accountIg.getNama());

        holder.ivStoryProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.context, StoryActivity.class);
                intent.putExtra("accountIg", accountIg);
                holder.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return accountIgs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivStoryProfile;
        TextView tv_name;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivStoryProfile = itemView.findViewById(R.id.iv_profile_sg);
            tv_name = itemView.findViewById(R.id.tv_username_sg);
            context = itemView.getContext();

        }
    }
}
