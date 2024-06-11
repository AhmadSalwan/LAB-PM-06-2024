package com.example.praktikum5;

import static com.example.praktikum5.DataSource.models;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AddFragment extends Fragment {

    private Button btn_add;
    private ImageView iv_post;
    private EditText et_desc;
    private Uri selectedImage;
    private ActivityResultLauncher<Intent> launcherIntentGallery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }
// untuk menampilkan isi layout
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_add = view.findViewById(R.id.btn_post);
        iv_post = view.findViewById(R.id.iv_post1);
        et_desc = view.findViewById(R.id.desc);
// buka gallery
        iv_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(Intent.ACTION_PICK);
                open.setType("image/*");
                launcherIntentGallery.launch(open);
            }
        });


        // Inisialisasi launcherIntentGallery untuk handling hasil dari galeri
        launcherIntentGallery = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            selectedImage = data.getData();
                            iv_post.setImageURI(selectedImage);
                            iv_post.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        }
                    }
                });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String konten = et_desc.getText().toString();
// jika select image dan konten nd ksong maka di buatkan datasource baru
                if (!konten.isEmpty() && selectedImage != null) {
                    Model newModel = new Model("Puss In Boots", "Puss", konten, R.drawable.cat5, selectedImage);
// menambahkan ke index 0
                    models.add(0, newModel);

// mengatur kembali ksong utk stiap inputan
                    et_desc.setText("");
                    iv_post.setImageResource(0);
                    selectedImage = null;

                    Toast.makeText(requireContext(), "Post added successfully", Toast.LENGTH_SHORT).show();

                    FragmentManager fragmentManager =getParentFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                } else {
                    Toast.makeText(requireContext(), "Please fill in content and select an image", Toast.LENGTH_SHORT).show();
                }
            }
        });
    } 
}