package com.example.praktikum3;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
// implementasi adapter untuk RecyclerView dalam kelas StoryAdapter
public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private ArrayList<Artis> artis;

    public StoryAdapter(ArrayList<Artis> artis) {
        this.artis = artis;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        Artis artis1 = artis.get(position);

        holder.ivStoryProfile.setImageResource(artis1.getImageprofile());
        holder.tv_name.setText(artis1.getNama());

    }

    @Override
    public int getItemCount() {
        return artis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivStoryProfile;
        TextView tv_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivStoryProfile = itemView.findViewById(R.id.iv_storyprofile);
            tv_name = itemView.findViewById(R.id.tv_nama);

            ivStoryProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition(); // Mendapatkan posisi item yang diklik
                    if (position != RecyclerView.NO_POSITION) { // Memastikan posisi item valid
                        Artis clickedArtis = DataSource.artis.get(position); // Mendapatkan objek University dari ArrayList berdasarkan posisi

                        // Membuat intent
                        Intent intent = new Intent(itemView.getContext(), MainActivity2.class);
                        // Mengirim data melalui intent
                        intent.putExtra("nama", clickedArtis.getNama());
                        intent.putExtra("imageprofile", clickedArtis.getImageprofile());
                        intent.putExtra("imagestory", clickedArtis.getImagestory());
                        intent.putExtra("imagefeed", clickedArtis.getImagefeed());
                        intent.putExtra("followers", clickedArtis.getFollowers());
                        intent.putExtra("following", clickedArtis.getFollowing());
                        intent.putExtra("caption", clickedArtis.getCaption());
                        intent.putExtra("position", position);
                        // Memulai MainActivity2
                        itemView.getContext().startActivity(intent);
                    }
                }
            });
        }
    }
}