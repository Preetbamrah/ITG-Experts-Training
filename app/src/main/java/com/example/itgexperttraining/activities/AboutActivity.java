package com.example.itgexperttraining.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.itgexperttraining.R;
import com.github.barteksc.pdfviewer.PDFView;

public class AboutActivity extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        toolbar = findViewById(R.id.action_about);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        PDFView pdfView = findViewById(R.id.aboutpdf);
        pdfView.fromAsset("itg.pdf")
                .enableAnnotationRendering(true)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .load();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
