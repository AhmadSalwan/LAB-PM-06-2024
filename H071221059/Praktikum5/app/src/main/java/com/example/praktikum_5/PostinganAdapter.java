package com.example.praktikum_5;

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

public class PostinganAdapter extends RecyclerView.Adapter<PostinganAdapter.ViewHolder> {

    private ArrayList<Sosialmedia> sosialmedias;

    public PostinganAdapter(ArrayList<Sosialmedia> sosialmedias) {
        this.sosialmedias = sosialmedias;
    }

    @NonNull
    @Override
    public PostinganAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postingan, parent, false);
        return new PostinganAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostinganAdapter.ViewHolder holder, int position) {

        Sosialmedia sosialmedia1 = sosialmedias.get(position);

        holder.TV_Username.setText(sosialmedia1.getUsername());
        holder.TV_Name.setText(sosialmedia1.getName());
        holder.TV_Desc.setText(sosialmedia1.getDesc());
        holder.IV_FotoProfile.setImageResource(sosialmedia1.getFotoProfile());
        holder.IV_FotoPostingan.setImageResource(sosialmedia1.getFotoPostingan());
        holder.IV_Feed.setImageURI(sosialmedia1.getSelectedImageUri());

        holder.IV_FotoProfile.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("sosialmedia", sosialmedia1);
            holder.context.startActivity(intent);
        });

        holder.TV_Name.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("sosialmedia", sosialmedia1);
            holder.context.startActivity(intent);
        });
        holder.TV_Username.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("sosialmedia", sosialmedia1);
            holder.context.startActivity(intent);
        });

    }


    @Override
    public int getItemCount() {
        return sosialmedias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TV_Username, TV_Name, TV_Desc;
        ImageView IV_FotoProfile, IV_FotoPostingan, IV_Feed;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TV_Username = itemView.findViewById(R.id.TV_Username);
            TV_Name = itemView.findViewById(R.id.TV_Name);
            TV_Desc = itemView.findViewById(R.id.TV_Desc);
            IV_FotoProfile = itemView.findViewById(R.id.IV_Profile);
            IV_FotoPostingan = itemView.findViewById(R.id.IV_Postingan);
            IV_Feed = itemView.findViewById(R.id.IV_Postingan);
            context = itemView.getContext();
        }
    }
}