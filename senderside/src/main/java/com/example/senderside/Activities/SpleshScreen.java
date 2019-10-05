package com.example.senderside.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.senderside.R;

public class SpleshScreen extends AppCompatActivity {
ImageView imageView;
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splesh_screen);

        imageView = findViewById(R.id.itg_image);
        /* textView = findViewById(R.id.itgtext);*/
        progressBar = findViewById(R.id.progress_bar);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LoginPage.class));
                finish();

            }
        }, 3000);

    }
}
