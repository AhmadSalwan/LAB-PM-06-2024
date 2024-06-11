package com.example.h071221048_andi_ahmad_salwan_tugas6_api;

import java.util.List;

public class UserResponse {
    private List<RecycleModel> data;
    public List<RecycleModel> getData(){
        return data;
    }
    public void setData(List<RecycleModel> data){
        this.data=data;
    }
}
