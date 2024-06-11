package com.example.tugasprak4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tugasprak4.MainActivity;
import com.example.tugasprak4.DataSource;
import com.example.tugasprak4.R;
import com.example.tugasprak4.PostAdapter;
import com.example.tugasprak4.Post;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    public static String EXTRA_POST = "extra_post";
    private TextView noDataTv;
    PostAdapter postAdapter;
    private RecyclerView postRecyclerView;
    private ArrayList<Post> posts = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        HomeFragment.super.onViewCreated(view, savedInstanceState);
        if (!(getActivity() == null || ((AppCompatActivity) getActivity()).getSupportActionBar() == null)) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Artis");
        }

        this.postRecyclerView = view.findViewById(R.id.recyclerView);
        this.noDataTv = (TextView) view.findViewById(R.id.textViewNoPosts);
        this.posts = DataSource.posts;
        this.postAdapter = new PostAdapter(this.posts, getActivity());
        this.postAdapter.setOnDeleteButtonClickedListener(new HomeFragment3 (this));
        if (getArguments() != null) {
            this.posts.add(0, getArguments().getParcelable(EXTRA_POST));
            Toast.makeText(getActivity(), "Post Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
            MainActivity mainActivity = (MainActivity) getActivity();
            if (mainActivity != null) {
                 mainActivity.isActiveHomeMenu(true);
                 mainActivity.isActivePostMenu(false);
                 mainActivity.isActiveProfileMenu(false);
            }

        }
        checkDataEmpty();
        this.postRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.postRecyclerView.setHasFixedSize(true);
        this.postRecyclerView.setAdapter(this.postAdapter);
    }

    public void HomeFragment3 (Post post) {
        ConfirmDialogFragment confirmDialogFragment = new ConfirmDialogFragment();
        confirmDialogFragment.show(getChildFragmentManager(), ConfirmDialogFragment.class.getSimpleName());
        Bundle bundle = new Bundle();
        bundle.putParcelable("post", post);
        confirmDialogFragment.setArguments(bundle);
        confirmDialogFragment.setOnClickDeleteButtonListener(new HomeFragment2(this, post));
    }

    public void HomeFragment2 (Post post) {
        this.posts.remove(post);
        this.postAdapter.notifyDataSetChanged();
        Toast.makeText(getActivity(), "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
        checkDataEmpty();
    }

    public void checkDataEmpty() {
        System.out.println(this.posts.isEmpty());
        if (this.posts.isEmpty()) {
            this.noDataTv.setVisibility(View.VISIBLE);
        } else {
            this.noDataTv.setVisibility(View.GONE);
        }
    }
}