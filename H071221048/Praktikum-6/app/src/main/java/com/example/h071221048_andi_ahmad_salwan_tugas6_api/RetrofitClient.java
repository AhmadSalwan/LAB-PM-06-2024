package com.example.h071221048_andi_ahmad_salwan_tugas6_api;

import retrofit2.Retrofit;
import  retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
        static final String BASE_URL="https://reqres.in/";
        static  Retrofit retrofit=null;

        static Retrofit getClient(){
            if (retrofit==null){
                retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create()).build();
            }
            return retrofit;
        }
    }

