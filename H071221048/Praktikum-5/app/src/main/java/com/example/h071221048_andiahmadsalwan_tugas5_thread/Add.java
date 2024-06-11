package com.example.h071221048_andiahmadsalwan_tugas5_thread;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class Add extends Fragment {


    String stringUri;
    ActivityResultLauncher<Intent> resultLauncher;
    ImageButton imgButton;
    EditText editText;
    Button submit;
    View view;
    static Uri uri,imageUri;
    boolean cekGambar=false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_add, container, false);
        imgButton=view.findViewById(R.id.iv_edit);
        editText=view.findViewById(R.id.tv_edit);
        submit=view.findViewById(R.id.button_submit);
        registerResult();

        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openGallery=new Intent(Intent.ACTION_PICK);
                openGallery.setType("image/*");
                resultLauncher.launch(openGallery);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTeks=editText.getText().toString();
                if(cekGambar!=true){
                    Toast.makeText(requireContext(), "No Image Selected", Toast.LENGTH_SHORT).show();
                }
                else if(editTeks.matches("")){
                    Toast.makeText(requireContext(), "No Comment Typed", Toast.LENGTH_SHORT).show();
                }else {
                    Bundle bundle = new Bundle();
                    Bundle bundle2=new Bundle();
                    bundle.putString("comment", editText.getText().toString());
                    bundle.putString("img", String.valueOf(imageUri));
                    bundle2.putString("comment", editText.getText().toString());
                    bundle2.putString("img", String.valueOf(imageUri));
                    getParentFragmentManager().setFragmentResult("datafromadd", bundle);
                    getParentFragmentManager().setFragmentResult("datafromAdd", bundle2);
                    editText.setText("");
                }
            }
        });
        return view;
    }
    private void registerResult(){
        resultLauncher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        try{
                            Intent data = result.getData();
                            if (data != null) {
                                imageUri = data.getData();
                                imgButton.setImageURI(imageUri);
                                cekGambar=true;
                            } else {
                                Toast.makeText(requireContext(), "No Image Selected", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            Toast.makeText(requireContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );

    }
}