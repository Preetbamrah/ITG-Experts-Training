package com.example.itgexperttraining.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.itgexperttraining.R;


public class CivilData extends AppCompatActivity implements View.OnClickListener {
    TextView textView1,textView2,textView3,textView4;
    Toolbar toolbar;
    RelativeLayout layout_autocad,layout_revit,layout_staad,layout_dsmax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil_data);
        textView1 = findViewById(R.id.textautocad);
        textView2 = findViewById(R.id.textstaad);
        textView3 = findViewById(R.id.textrevit);
        textView4 = findViewById(R.id.textds);
        toolbar = findViewById(R.id.action);
        layout_staad = findViewById(R.id.staad_rela);
        layout_revit = findViewById(R.id.revit_rela);
        layout_dsmax = findViewById(R.id.ds_max_rela);
        layout_autocad = findViewById(R.id.autocad_rela);
        layout_autocad.setOnClickListener(this);
        layout_dsmax.setOnClickListener(this);
        layout_revit.setOnClickListener(this);
        layout_staad.setOnClickListener(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void onClick(View view)
    {
            switch (view.getId())
            {
                case R.id.autocad_rela:
                    Intent autocad = new Intent(Intent.ACTION_VIEW);
                    autocad.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/autocad.pdf?alt=media&token=61830da5-bb39-4377-8d8f-7f1a1600d568"));
                    startActivity(autocad);
                    break;
                case R.id.ds_max_rela:
                    Intent ds = new Intent(Intent.ACTION_VIEW);
                    ds.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/ds.pdf?alt=media&token=8d962005-8fd5-432a-b866-5b7b15432904"));
                    startActivity(ds);
                    break;
                case R.id.staad_rela:
                    Intent staad = new Intent(Intent.ACTION_VIEW);
                    staad.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/staadpro.pdf?alt=media&token=c1eb36ef-824b-47d2-a694-4e22e348dab0"));
                    startActivity(staad);
                    break;
                case R.id.revit_rela:
                    Intent revit = new Intent(Intent.ACTION_VIEW);
                    revit.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/revit.pdf?alt=media&token=f96c7bd6-b07e-41a1-aa6c-1c3b2a952f27"));
                    startActivity(revit);
                    break;
                default:
                    break;
            }
    }
}
