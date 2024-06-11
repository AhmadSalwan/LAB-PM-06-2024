package com.example.praktikum5;
// menghubungkan datasource ke layout
import android.annotation.SuppressLint;
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
import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder> {
    private ArrayList<Model> models;
    private Context context;

    public ModelAdapter(ArrayList<Model> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public ModelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postingan, parent, false);

        return new ModelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Model model = models.get(position);
        holder.tv_nama.setText(model.getNama());
        holder.tv_username.setText(model.getUsername());
        holder.tv_konten.setText(model.getCaption());
        holder.iv_profile.setImageResource(model.getProfile());
        if (model.getPostingan() != null) {
            holder.iv_post.setImageResource(model.getPostingan());
        }
        if (model.getSelectedImage() != null) {
            holder.iv_post.setImageURI(model.getSelectedImage());
        }


        holder.tv_nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("model", model);
                holder.context.startActivity(intent);
            }
        });

        holder.iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("model", model);
                holder.context.startActivity(intent);
            }
        });
// button ke profil activity
        holder.tv_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("model", model);
                holder.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }


    public void setData(ArrayList<Model> models) {
        this.models = models;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama, tv_username, tv_konten;
        ImageView iv_profile, iv_post;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_nama);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_konten = itemView.findViewById(R.id.tv_konten);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            iv_post = itemView.findViewById(R.id.iv_post);
            context = itemView.getContext();
        }
    }
}
