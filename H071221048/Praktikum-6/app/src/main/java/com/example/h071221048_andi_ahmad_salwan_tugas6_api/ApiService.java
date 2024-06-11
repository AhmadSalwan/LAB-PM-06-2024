package com.example.h071221048_andi_ahmad_salwan_tugas6_api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users/")
    Call<UserResponse> getUsers(@Query("page")int page);
}
