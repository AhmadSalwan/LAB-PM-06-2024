package com.example.tugasprak4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.example.tugasprak4.DataSource;
import com.example.tugasprak4.R;
import com.example.tugasprak4.Post;

public class PostFragment extends Fragment {
    private EditText descriptionEt;
    private ImageView imgContentIv;
    ActivityResultLauncher<Intent> openGallery = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new PostFragment2 (this));
    private Button postingBtn;
    private Uri selectedImg;


    // utk mengambil gambar yg dipilih dri galery
    public void PostFragment2 (ActivityResult result) {
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            if (data != null) {
                this.selectedImg = data.getData();
                this.imgContentIv.setImageURI(this.selectedImg);
                return;
            }
            Toast.makeText(getActivity(), "Data Kosong", Toast.LENGTH_LONG).show();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        PostFragment.super.onViewCreated(view, savedInstanceState);
        if (!(requireActivity() == null || ((AppCompatActivity) requireActivity()).getSupportActionBar() == null)) {
            ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle("Add Post");
        }
        this.descriptionEt = (EditText) view.findViewById(R.id.descriptionEt);
        this.imgContentIv = (ImageView) view.findViewById(R.id.imgContentIv);
        this.postingBtn = (Button) view.findViewById(R.id.postingBtn);
        this.imgContentIv.setOnClickListener(new PostFragment3(this));
        this.postingBtn.setOnClickListener(new PostFragment4 (this));
    }

    // untuk open gallery
    public void PostFragment3 (View v) {
        Intent intent = new Intent("android.intent.action.PICK");
        // untuk menngambil semua tipe gambar seperti png, jpg dll
        intent.setType("image/*");
        this.openGallery.launch(intent);
    }

    // kalo tidak diisi konten dan foto nya dia akan memunculkan text seperti dibawah
    public void PostFragment4 (View v) {
        if (this.descriptionEt.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "Konten Masih Kosong", Toast.LENGTH_LONG).show();
        } else if (this.selectedImg == null) {
            Toast.makeText(getActivity(), "Pilih Gambar Terlebih Dahulu", Toast.LENGTH_LONG).show();
        } else {
            HomeFragment homeFragment = new HomeFragment();
            Post newPost = new Post(this.selectedImg, this.descriptionEt.getText().toString(), DataSource.user);
            Bundle bundle = new Bundle();
            bundle.putParcelable(HomeFragment.EXTRA_POST, newPost);
            homeFragment.setArguments(bundle);
            getParentFragmentManager().beginTransaction().replace(((ViewGroup)getView().getParent()).getId(), homeFragment, HomeFragment.class.getSimpleName()).commit();

        }
    }
}