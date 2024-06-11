package com.example.tugasprak4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.DialogFragment;
import com.example.tugasprak4.DataSource;
import com.example.tugasprak4.R;
import com.example.tugasprak4.Post;

public class ConfirmDialogFragment extends DialogFragment {
    private Button btnBatal;
    private Button btnHapus;
    DialogListener dialogListener;
    Post post;

    interface DialogListener {
        void setOnClickDeleteButton();
    }

    public void setOnClickDeleteButtonListener(DialogListener dialogListener2) {
        this.dialogListener = dialogListener2;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_confirm_dialog, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        ConfirmDialogFragment.super.onViewCreated(view, savedInstanceState);
        this.btnBatal = (Button) view.findViewById(R.id.button_cancel);
        this.btnHapus = (Button) view.findViewById(R.id.button_delete);
        if (getArguments() != null) {
            this.post = getArguments().getParcelable("post");
        }
        this.btnBatal.setOnClickListener(new ConfirmDialogFragment2 (this));
        this.btnHapus.setOnClickListener(new ConfirmDialogFragment3 (this));
    }


    public void ConfirmDialogFragment2 (View v) {
        getDialog().cancel();
    }

    public void ConfirmDialogFragment3 (View v) {
        DataSource.posts.remove(this.post);
        this.dialogListener.setOnClickDeleteButton();
        getDialog().dismiss();
    }
}