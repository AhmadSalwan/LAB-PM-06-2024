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
// memhubungkan ant resau sma layaout untuk recyleview
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private ArrayList<Artis> artis;

    public FeedAdapter(ArrayList<Artis> artis){this.artis = artis;}

    @NonNull
    @Override
    public FeedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed, parent, false);
        return new FeedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdapter.ViewHolder holder, int position) {

        Artis artis1 = artis.get(position);

        holder.tv_namaProfile.setText(artis1.getNama());
        holder.ivProfile.setImageResource(artis1.getImageprofile());
        holder.ivFeed.setImageResource(artis1.getImagefeed());
        holder.tv_caption.setText(artis1.getCaption());
    }

    @Override
    public int getItemCount() {
        return artis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFeed, ivProfile;
        TextView tv_caption, tv_namaProfile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFeed = itemView.findViewById(R.id.iv_feed);
            ivProfile = itemView.findViewById(R.id.iv_profile);
            tv_namaProfile = itemView.findViewById(R.id.tv_namaprofile);
            tv_caption = itemView.findViewById(R.id.tv_caption);

            ivProfile.setOnClickListener(new View.OnClickListener() {
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

            tv_namaProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition(); // Mendapatkan posisi item yang diklik
                    if (position != RecyclerView.NO_POSITION) { // Memastikan posisi item valid
                        Artis clickedArtis = DataSource.artis.get(position); // Mendapatkan objek University dari ArrayList berdasarkan posisi

                        // Membuat intent
                        Intent intent = new Intent(itemView.getContext(), MainActivity3.class);
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
