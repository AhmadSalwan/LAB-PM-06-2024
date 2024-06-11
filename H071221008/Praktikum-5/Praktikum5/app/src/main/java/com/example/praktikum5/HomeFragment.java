package com.example.praktikum5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    private RecyclerView rv_post;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_post = view.findViewById(R.id.rv_feed);
        rv_post.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_post.setHasFixedSize(true);
        ModelAdapter modelAdapter = new ModelAdapter(DataSource.models);
        rv_post.setAdapter(modelAdapter);
// misal jika tdk null di models maka akan mengeset adapter brdsrkan datasource
        if (DataSource.models != null && !DataSource.models.isEmpty()) {
            modelAdapter.setData(DataSource.models);
        }
    }
}