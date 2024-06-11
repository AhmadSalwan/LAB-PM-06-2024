package com.example.h071221048_andiahmadsalwan_tugas5_thread;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Search extends Fragment implements RecyclerViewInterface{
    RecyclerView recyclerView;
    ArrayList<SearchRcvModel> recycle_model =new ArrayList<>();
    SearchRcvAdapter adapter;
    SearchView searchViewUi;
    public static List<Uri> pfimages = new ArrayList<>();
    public static List<String> names = new ArrayList<String>();
    public static List<String> bio = new ArrayList<String>();

    public static boolean firstleft = MainActivity.isFirstLeft();
    static ArrayList<SearchRcvModel> filteredList=new ArrayList<>();
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable searchRunnable;
    private ProgressBar spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (firstleft == true) {
            initializeList();
        } else if (firstleft != true) {
            setUpRecycle();
        }
        try {
            filteredList.clear();
            adapter.notifyDataSetChanged();

        }catch (Exception e){
//
        }
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        searchViewUi = view.findViewById(R.id.searchView);
        adapter=new SearchRcvAdapter(requireContext(),filteredList,this);
        recyclerView = view.findViewById(R.id.searchRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        spinner=view.findViewById(R.id.progressBar1);
        spinner.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
        searchViewUi.clearFocus();
        getParentFragmentManager().setFragmentResultListener("datafromAdd",
                this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        String[] name = getResources().getStringArray(R.array.MyProfile);
                        if ( names.get(names.size()-1).equals(name[0])) {
                        }else {
                            Toast.makeText(getContext(), recycle_model.size() +
                                    "Found" + names.get(names.size() - 1) + name[0], Toast.LENGTH_SHORT).show();
                            names.add(name[0]);
                            bio.add(name[1]);
                            pfimages.add(Uri.parse("android.resource://com.example.h071221048_andiahmadsalwan_tugas5_thread/" + R.drawable.myprofile));
                            recycle_model.clear();
                            setUpRecycle();
                        }}});
        searchViewUi.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (searchRunnable != null) {
                    handler.removeCallbacks(searchRunnable);
                }
                filterList(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (searchRunnable != null) {
                    handler.removeCallbacks(searchRunnable);
                }
                recyclerView.setVisibility(View.INVISIBLE);
                spinner.setVisibility(View.VISIBLE);
                filteredList.clear();
                adapter.notifyDataSetChanged();
                if(newText.isEmpty()){
                    spinner.setVisibility(View.INVISIBLE);
                }
                else {
                    handler.postDelayed(() -> {
                        recyclerView.setVisibility(View.VISIBLE);
                        spinner.setVisibility(View.INVISIBLE);
                    }, 2000);
                    filterList(newText);
                }
                return true;
            }
        });

        return view;
    }

    private void filterList(String newText) {

        for (SearchRcvModel item:recycle_model){
            if(item.getName().toLowerCase()
                    .contains(newText.toLowerCase())){
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()){
            filteredList.clear();
            adapter.notifyDataSetChanged();
//            handler.postDelayed(()->{
//            Toast.makeText(getContext(),"No Data " +
//                    "Found",Toast.LENGTH_SHORT).show();
//            },2000);
        }else{
            adapter.setFilteredList(filteredList);
        }


    }


    public void setUpRecycle(){
    recycle_model.clear();
            for (int i = 0; i < names.size(); i++) {
                recycle_model.add(new SearchRcvModel(
                        pfimages.get(i),
                        names.get(i),
                        bio.get(i)
                        ));}
            if(adapter!=null){
                adapter.notifyDataSetChanged();
            }


    }

    public void initializeList() {
        MainActivity.setFirstLeft(false);
        firstleft = false;
        String[] name = getResources().getStringArray(R.array.Presiden);
        String[] Bio = getResources().getStringArray(R.array.Bio);
        String[] str = {
                "android.resource://com.example.h071221048_andiahmadsalwan_tugas5_thread/" + R.drawable.soekarno,
                "android.resource://com.example.h071221048_andiahmadsalwan_tugas5_thread/" + R.drawable.soeharto,
                "android.resource://com.example.h071221048_andiahmadsalwan_tugas5_thread/" + R.drawable.habibie,
                "android.resource://com.example.h071221048_andiahmadsalwan_tugas5_thread/" + R.drawable.gusdur,
                "android.resource://com.example.h071221048_andiahmadsalwan_tugas5_thread/" + R.drawable.megawati,
                "android.resource://com.example.h071221048_andiahmadsalwan_tugas5_thread/" + R.drawable.sby,
                "android.resource://com.example.h071221048_andiahmadsalwan_tugas5_thread/" + R.drawable.jokowi,

        };

        Uri[] image = new Uri[str.length];
        for (int i = 0; i < str.length; i++) {
            image[i] = Uri.parse(str[i]);
        }
        names.clear();
        bio.clear();
        pfimages.clear();
        Collections.addAll(names, name);
        Collections.addAll(bio, Bio);
       Collections.addAll(pfimages,image);
        setUpRecycle();
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void showFull(int position) {
        Toast.makeText(getContext(),filteredList.size() +
                    "Found",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(requireContext(),FullView.class);

        intent.putExtra("name",filteredList.get(position).getName());
        intent.putExtra("image",String.valueOf( filteredList.get(position).getPf_image()));
        intent.putExtra("comment",filteredList.get(position).getBio());
        startActivity(intent);
    }
}