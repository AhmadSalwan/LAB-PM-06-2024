package com.example.praktikum5;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktikum5.DataSource;
import com.example.praktikum5.Model;
import com.example.praktikum5.R;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SearchFragment extends Fragment {

    private SearchView searchView;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private SearchAdapter searchAdapter;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable searchRunnable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchView = view.findViewById(R.id.search_user);
        recyclerView = view.findViewById(R.id.rv_search);
        progressBar = view.findViewById(R.id.pb1);
// menghubungkan adapter ke layout
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        searchAdapter = new SearchAdapter(new ArrayList<>());
        recyclerView.setAdapter(searchAdapter);

        // Mengatur listener untuk SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Hapus callback pencarian sebelumnya (jika ada) sebelum membuat yang baru
                handler.removeCallbacks(searchRunnable);

                // Buat callback baru untuk pencarian dengan penundaan 1.5 detik
                searchRunnable = () -> filterList(newText);

                // Jalankan pencarian setelah penundaan 1.5 detik
                handler.postDelayed(searchRunnable, 1500);

                if (!Objects.equals(newText, "")) {
                    progressBar.setVisibility(View.VISIBLE);
                }
                recyclerView.setVisibility(View.GONE);

                return true;
            }
        });
    }

    private void filterList(String text) {
        if (text.isEmpty()) {
            // Jika teks kosong, sembunyikan RecyclerView dan reset data adapter
            recyclerView.setVisibility(View.GONE);
            searchAdapter.setFilteredList(new ArrayList<>());
            progressBar.setVisibility(View.GONE); // Sembunyikan ProgressBar
            return;
        }

        // Tampilkan ProgressBar saat memulai filtering
        progressBar.setVisibility(View.VISIBLE);

        ArrayList<Model> filteredList = new ArrayList<>();
        for (Model model : DataSource.models) {
            if (model.getNama().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(model);
            }
        }

        progressBar.setVisibility(View.GONE); // Sembunyikan ProgressBar

        if (filteredList.isEmpty()) {
            Toast.makeText(requireContext(), "Data Not Found", Toast.LENGTH_SHORT).show();
        }

        // Tampilkan RecyclerView dan update data adapter dengan hasil filtering
        recyclerView.setVisibility(View.VISIBLE);
        searchAdapter.setFilteredList(filteredList);


    }
}
