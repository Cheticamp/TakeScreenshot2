package com.example.takescreenshot;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
    public MyDialogFragment() {
    }

    public static MyDialogFragment newInstance() {
        return new MyDialogFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        return inflater.inflate(R.layout.card_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.cardView).setOnClickListener((View.OnClickListener) getActivity());
    }

    public void takeScreenShot(BitmapCallback callback) {
        ViewImage.getScreenShotFromView(getDialog().findViewById(R.id.cardView), getDialog().getWindow(),
                (bm) -> {
                    getDialog().dismiss();
                    callback.showCapturedImage(bm);
                    return null;
                });
    }

    interface BitmapCallback {
        void showCapturedImage(Bitmap bitmap);
    }
}