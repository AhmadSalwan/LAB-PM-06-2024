package com.example.praktikum6;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailActivity extends AppCompatActivity {

    ImageView ivProfile;
    TextView tvNama, tvEmail, tvHeadDetail, tvBodyDetail;
    ProgressBar pbDetail, pbOffDetail;
    LinearLayout llDetail, llOffDetail;
    private ApiService apiService;
    ImageView ivOffDetail;
    Button btnRetryDetail;
    private boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivProfile = findViewById(R.id.ivProfile);
        tvNama = findViewById(R.id.tvNama);
        tvEmail = findViewById(R.id.tvEmail);
        pbDetail = findViewById(R.id.pbDetail);
        llDetail = findViewById(R.id.llDetail);
        tvHeadDetail = findViewById(R.id.tvHeadDetail);
        tvBodyDetail = findViewById(R.id.tvBodyDetail);
        btnRetryDetail = findViewById(R.id.btnRetryDetail);
        pbOffDetail = findViewById(R.id.pbOffDetail);
        ivOffDetail = findViewById(R.id.ivOffDetail);
        llOffDetail = findViewById(R.id.internetOffDetail);
// mengambil nilai ID pengguna dari intent kemudian mengambil detail pengguna menggunakan layanan API
//smbunyikn suatu layout dan memanggil metode untuk mengambil detail pengguna.
// jika intent tidak memiliki nilai dengan kunci "USER_ID", maka nilai yang dikembalikan akan menjadi -1
        Intent intent = getIntent();
        int userId = intent.getIntExtra("USER_ID", -1);
        Log.d("massage", "onCreate: " + userId);

        apiService = RetrofitClient.getClient().create(ApiService.class);
        llOffDetail.setVisibility(View.GONE);

        fetchUserDetails(userId);

        btnRetryDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sembunyikan komponen UI yang terkait dengan tampilan offline
                ivOffDetail.setVisibility(View.GONE);
                tvHeadDetail.setVisibility(View.GONE);
                tvBodyDetail.setVisibility(View.GONE);
                btnRetryDetail.setVisibility(View.GONE);

                // Tampilkan ProgressBar untuk menunjukkan bahwa aplikasi sedang mencoba menghubungkan kembali
                pbOffDetail.setVisibility(View.VISIBLE);
                fetchUserDetails(userId);
                // Membuat dan menjalankan thread untuk mencoba menghubungkan kembali
            }
        });
    }
// off internet
    private void fetchUserDetails(int userId) {
        pbDetail.setVisibility(View.VISIBLE);
        llDetail.setVisibility(View.GONE);
        Call<UserDetailResponse> call = apiService.getUserDetails(userId);
        call.enqueue(new Callback<UserDetailResponse>() {
            @Override
            public void onResponse(Call<UserDetailResponse> call, Response<UserDetailResponse> response) {
                pbDetail.setVisibility(View.GONE);
                pbOffDetail.setVisibility(View.GONE);
                llOffDetail.setVisibility(View.GONE);
                isLoading = false;
                if (response.isSuccessful() && response.body() != null) {
                    User user = response.body().getData();
                    llDetail.setVisibility(View.VISIBLE);
                    displayUserDetails(user);
                } else {
                    showError("Failed to fetch user details. Please try again later.");
                }
            }

            @Override
            public void onFailure(Call<UserDetailResponse> call, Throwable t) {
                Log.d("Massage", "onFailure: ");
                pbDetail.setVisibility(View.GONE);
                llDetail.setVisibility(View.GONE);
                isLoading = false;
                // Tampilkan komponen UI yang menunjukkan bahwa koneksi internet tidak terhubung
                llOffDetail.setVisibility(View.VISIBLE);
                ivOffDetail.setVisibility(View.VISIBLE);
                tvHeadDetail.setVisibility(View.VISIBLE);
                tvBodyDetail.setVisibility(View.VISIBLE);
                btnRetryDetail.setVisibility(View.VISIBLE);
                pbOffDetail.setVisibility(View.GONE);
            }
        });
    }

    private void displayUserDetails(User user) {
        if (user != null) {
            tvNama.setText(user.getFirst_name() + " " + user.getLast_name());
            tvEmail.setText(user.getEmail());
            Picasso.get().load(user.getAvatar()).into(ivProfile);
        } else {
            showError("User details not found.");
        }
    }

    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}