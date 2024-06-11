package com.example.h071221048_andi_ahmad_salwan_tugas6_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity implements OnClickInterface{
    private ApiService apiService;
    private RecyclerView recyclerView;
    private RecyclerAdapter userAdapter;
    List<RecycleModel> users;
    boolean HasClicked=false;
    private ProgressBar spinner;
    private Handler handler = new Handler(Looper.getMainLooper());
    ExecutorService service= Executors.newFixedThreadPool(2);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService=RetrofitClient.getClient().create(ApiService.class);
//        apiService2=RetrofitClient.getClient().create(ApiService.class);
        recyclerView=findViewById(R.id.myrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        View load=findViewById(R.id.button_load);
        spinner=findViewById(R.id.progressBar);
        spinner.setVisibility(View.INVISIBLE);

        service.execute(new Runnable(){
            @Override
                    public void run(){
                Call<UserResponse> call=apiService.getUsers(1);

                call.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        if(response.isSuccessful()){
                            users=response.body().getData();
                            userAdapter=new RecyclerAdapter(MainActivity.this,users,MainActivity.this);

                            recyclerView.setAdapter(userAdapter);
                            load.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(HasClicked==false){
                                        fetchmore();
                                        HasClicked=true;
                                        load.setVisibility(View.INVISIBLE);
                                        spinner.setVisibility(View.VISIBLE);
                                    }}
                            });
                        }
                    }
                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {

                    }
                });
            }

        });



    }
    void fetchmore() {
        Call<UserResponse> call2 = apiService.getUsers(2);
        call2.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                        recyclerView.setVisibility(View.VISIBLE);
                        spinner.setVisibility(View.INVISIBLE);
                        List<RecycleModel> new_user=response.body().getData();
                        users.addAll(new_user);
                        userAdapter.notifyDataSetChanged();

                }
            };

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }


    @Override
    public void onItemClick(int pos) {
        Intent intent = new Intent(MainActivity.this,FullView.class);
        intent.putExtra("name",users.get(pos).getFirst_name()+" "+users.get(pos).getLast_name());
        intent.putExtra("img", users.get(pos).getImage());
        intent.putExtra("email",users.get(pos).getEmail());
        startActivity(intent);
    }
}