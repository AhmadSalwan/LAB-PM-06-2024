package com.example.h071221048_andiahmadsalwan_tugas5_thread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchRcvAdapter extends RecyclerView.Adapter<SearchRcvAdapter.MyViewHolder>{
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<SearchRcvModel> recycle_model;

    public SearchRcvAdapter( Context context, ArrayList<SearchRcvModel> recycle_model,RecyclerViewInterface recyclerViewInterface) {

        this.context = context;
        this.recycle_model = recycle_model;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public void setFilteredList(ArrayList<SearchRcvModel> filteredList){
        this.recycle_model=filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchRcvAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.searchrcv, parent, false);
        return new SearchRcvAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchRcvAdapter.MyViewHolder holder, int position) {
        holder.name.setText(recycle_model.get(position).getName());
        holder.bio.setText(recycle_model.get(position).getBio());
        holder.pf_image.setImageURI(recycle_model.get(position).getPf_image());
    }

    @Override
    public int getItemCount() {
        return recycle_model.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView pf_image;
        TextView name,bio;
        public MyViewHolder(@NonNull View itemView ,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            pf_image = itemView.findViewById(R.id.search_image);
            name = itemView.findViewById(R.id.search_name);
            bio = itemView.findViewById(R.id.search_bio);

            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.showFull(pos);
                        }
                    }
                }
            });
            bio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.showFull(pos);
                        }
                    }
                }
            });
            pf_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.showFull(pos);
                        }
                    }
                }
            });
        }
    }
}
