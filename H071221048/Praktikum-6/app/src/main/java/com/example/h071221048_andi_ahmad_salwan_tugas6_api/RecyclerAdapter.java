package com.example.h071221048_andi_ahmad_salwan_tugas6_api;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>  {
    OnClickInterface onClickInterface;
    Context context;
    List<RecycleModel> recycleModels;

    public RecyclerAdapter(Context context, List<RecycleModel> recycleModels,OnClickInterface onClickInterface ) {
        this.context = context;
        this.recycleModels = recycleModels;
        this.onClickInterface=onClickInterface;

    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview, parent, false);
        return new RecyclerAdapter.MyViewHolder(view,onClickInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
       RecycleModel users=recycleModels.get(position);
       holder.bind(users);
    }

    @Override
    public int getItemCount() {
        return recycleModels.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder  {
        ImageView image;
        TextView name,email;
        public MyViewHolder(@NonNull View itemView,OnClickInterface onClickInterface) {
            super(itemView);
            image=itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id.tv_name);
            email=itemView.findViewById(R.id.tv_email);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onClickInterface != null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            onClickInterface.onItemClick(pos);
                        }
                    }
                }
                }
            );
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onClickInterface != null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            onClickInterface.onItemClick(pos);
                        }
                    }
                }
            }
            );
            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onClickInterface != null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            onClickInterface.onItemClick(pos);
                        }
                    }
                }
            }
            );
        }
        public void bind(RecycleModel user){
            Picasso.get().load(user.getImage()).into(image);
            name.setText(user.getFirst_name()+" "+user.getLast_name());
            email.setText(user.getEmail());
        }

    }


}
