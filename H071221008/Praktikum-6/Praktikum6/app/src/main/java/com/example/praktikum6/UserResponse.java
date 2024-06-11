package com.example.praktikum6;
//keempat
// untuk mengambil data dri api dlm bentuk list
import java.util.List;

public class UserResponse {
    private List<User> data;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
