package com.example.h071221048_andiahmadsalwan_tugas5_thread;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Home extends Fragment implements RecyclerViewInterface {

    ArrayList<RecyclerViewModel> recycle_model=new ArrayList<>();
    RecyclerViewAdapter adapter;
    Uri uri;
    View view;
    static List<Integer> pfimages=new ArrayList<>();
    static List<Uri> images=new ArrayList<>();
    static List<String> names=new ArrayList<String>();
    static List<String> bio=new ArrayList<String>();
    static List<String> comment=new ArrayList<String>();
    public static boolean firstleft=MainActivity.isFirstLeft();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (firstleft == true) {
            initializeList();
        } else if (firstleft!=true) {
            setUpRecycle();
        }
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.homeRecyclerView);
        adapter=new RecyclerViewAdapter( requireContext(),recycle_model,this);

        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(requireContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);



        getParentFragmentManager().setFragmentResultListener("datafromadd",
                this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        String[] name= getResources().getStringArray(R.array.MyProfile);
                        String data=result.getString("comment");
                        String picture= result.getString("img");
                        names.add(name[0]);
                        bio.add(name[1]);
                        comment.add(data);
                        pfimages.add(R.drawable.myprofile);
                        uri=Uri.parse(picture);
                        images.add(uri);
                        recycle_model.clear();
                        setUpRecycle();


                    }
                });

        return view;
    }
    public void setUpRecycle(){
        recycle_model.clear();
        if (names.size()==images.size()) {

            for (int i = 0; i < names.size(); i++) {
                recycle_model.add(new RecyclerViewModel(
                        pfimages.get(i),
                        names.get(i),
                        bio.get(i),
                        comment.get(i),
                        images.get(i)));
            }
        }else {

            for (int i = 0; i < images.size(); i++) {
                recycle_model.add(new RecyclerViewModel(pfimages.get(i), names.get(i), bio.get(i),
                        comment.get(i), images.get(i)));
            }
            int lastImageIndex=pfimages.size()-1;
            int lastIndex=names.size()-1;
            recycle_model.add(new RecyclerViewModel(pfimages.get(lastImageIndex),names.get(lastIndex),bio.get(lastIndex),
                    comment.get(lastIndex), uri));
            Collections.reverse(recycle_model);
            adapter.notifyDataSetChanged();
        }

    }
    public  void initializeList(){
      firstleft=false;
        String[] name=getResources().getStringArray(R.array.Presiden);
        String[] Bio=getResources().getStringArray(R.array.Bio);
        String[] Comment=getResources().getStringArray(R.array.Comments);

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
        int[] pfimage={R.drawable.soekarno,R.drawable.soeharto,R.drawable.habibie,R.drawable.gusdur,R.drawable.megawati,R.drawable.sby,R.drawable.jokowi};
        for (String nama:name){
            names.add(nama);
        }
        for (String descript:Bio){
            bio.add(descript);
        }
        for (String descriptlong:Comment){
            comment.add(descriptlong);
        }
        for(Integer pimages:pfimage){
            pfimages.add(pimages);
        }
        for(Uri gambar:image){
            images.add(gambar);
        }
        setUpRecycle();
    }

    @Override
    public void onItemClick(int position) {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(requireContext());
        alertDialog.setMessage("Delete this item?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        recycle_model.remove(position);
                        names.remove(position);
                        images.remove(position);
                        bio.remove(position);
                        comment.remove(position);
                        pfimages.remove(position);
                        adapter.notifyItemRemoved(position);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
        AlertDialog dialog=alertDialog.create();
        dialog.show();
    }

    @Override
    public void showFull(int position) {
        Intent intent = new Intent(requireContext(),FullView.class);
        intent.putExtra("name",recycle_model.get(position).getName());
        intent.putExtra("img", recycle_model.get(position).getPf_image());
        intent.putExtra("comment",recycle_model.get(position).getComment());
        startActivity(intent);
    }
}