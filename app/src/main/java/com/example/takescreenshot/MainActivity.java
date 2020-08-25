package com.example.takescreenshot;

// See https://stackoverflow.com/questions/63448747/cardview-rounded-corners-are-not-showing-up-in-screenshot/63571521#63571521

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyDialogFragment myDialogFragment;
    ImageView capturedImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        capturedImageView = findViewById(R.id.capturedImage);

        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStack("myfragment", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        myDialogFragment = MyDialogFragment.newInstance();
        myDialogFragment.show(fm, "myfragment");
    }

    @Override
    public void onClick(View view) {
        myDialogFragment.takeScreenShot((bm) -> capturedImageView.setImageBitmap(bm));
    }

}
