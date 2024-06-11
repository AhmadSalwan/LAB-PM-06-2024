package com.example.tugasprak4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tugasprak4.DetailActivity;
import com.example.tugasprak4.ProfileFragment;
import com.example.tugasprak4.Post;
import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private ClickListener clickListener;
    private final Context context;
    private final ArrayList<Post> posts;

    public interface ClickListener {
        void onDeleteButtonClicked(Post post);
    }

    public PostAdapter(ArrayList<Post> posts2, Context context2) {
        this.posts = posts2;
        this.context = context2;
    }

    public void setOnDeleteButtonClickedListener(ClickListener clickListener2) {
        this.clickListener = clickListener2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_post, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // untuk mengambil elemen dari tiap id (kek imgProfileIv itu untuk ambil gambar profile)
        Post singlePost = this.posts.get(position);
        holder.imgProfileIv.setImageResource(singlePost.getUser().getProfileImg());
        holder.usernameTv.setText(singlePost.getUser().getUsername());
        holder.nameTv.setText(singlePost.getUser().getName());
        holder.descriptionTv.setText(singlePost.getDescription());
        holder.imgPostIv.setImageURI(singlePost.getImg());
        holder.deleteBtn.setOnClickListener(new PostAdapter2(this,singlePost)) ;
        holder.profileContainer.setOnClickListener(new PostAdapter3(this, singlePost));

    }
    public void PostAdapter2 (Post singlePost, View view) {
        this.clickListener.onDeleteButtonClicked(singlePost);
    }

    // untuk kalo di click profile nya dia langsung menuju ke halaman profile
    public void PostAdapter3 (Post singlePost, View view) {
        Intent i = new Intent(this.context, DetailActivity.class);
        i.putExtra(ProfileFragment.EXTRA_USER, singlePost.getUser());
        this.context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return this.posts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Context context;
        ImageButton deleteBtn;
        TextView descriptionTv;
        ImageView imgPostIv;
        ImageView imgProfileIv;
        TextView nameTv;
        LinearLayout profileContainer;
        TextView usernameTv;


        // untuk cari id dari variabel
        public ViewHolder(View itemView) {
            super(itemView);
            this.imgProfileIv = itemView.findViewById(R.id.image_view);
            this.imgPostIv = itemView.findViewById(R.id.image_view2);
            this.usernameTv = itemView.findViewById(R.id.text_view1);
            this.nameTv = itemView.findViewById(R.id.text_view2);
            this.descriptionTv = itemView.findViewById(R.id.text_view3);
            this.deleteBtn = itemView.findViewById(R.id.image_button_trash);
            this.profileContainer = itemView.findViewById(R.id.linear_layout1);
            this.context = itemView.getContext();
        }
    }
}
