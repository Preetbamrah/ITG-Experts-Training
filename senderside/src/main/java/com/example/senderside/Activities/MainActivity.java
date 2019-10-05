package com.example.senderside.Activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.senderside.R;
import com.github.barteksc.pdfviewer.PDFView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
PDFView pdfView;
Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        pdfView = findViewById(R.id.about_pdf);
        pdfView.fromAsset("itg.pdf")
                .enableAnnotationRendering(true)
                .enableDoubletap(true)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .load();
    }
}
  /*final String SrcPath = ("android.resource://" + getPackageName() + "/" + R.raw.autocad);
        VideoView videoView = findViewById(R.id.autocad_video);
        videoView.setVideoPath(SrcPath);
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();
*/