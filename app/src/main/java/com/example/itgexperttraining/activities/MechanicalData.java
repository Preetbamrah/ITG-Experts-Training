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


public class MechanicalData extends AppCompatActivity implements  View.OnClickListener{
    TextView autocad,cnc,solid,catia,cam;
    Toolbar toolbar;
    RelativeLayout layout_auto,layout_solid,layout_catia,layout_cnc,layout_nxcad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanical_data);
        autocad = findViewById(R.id.textauto);
        cnc = findViewById(R.id.textcnc);
        catia = findViewById(R.id.textcatid);
        solid = findViewById(R.id.textsolid);
        cam = findViewById(R.id.mxcam);
        layout_auto = findViewById(R.id.autocad_rela);
        layout_catia = findViewById(R.id.catia_rela);
        layout_cnc = findViewById(R.id.cnc_rela);
        layout_nxcad = findViewById(R.id.nx_rela);
        layout_solid = findViewById(R.id.solid_rela);
        layout_solid.setOnClickListener(this);
        layout_nxcad.setOnClickListener(this);
        layout_cnc.setOnClickListener(this);
        layout_catia.setOnClickListener(this);
        layout_auto.setOnClickListener(this);
        toolbar = findViewById(R.id.action_mechanical);
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
    public  void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.solid_rela:
                Intent solid = new Intent(Intent.ACTION_VIEW);
                solid.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/solidword.pdf?alt=media&token=8af14570-d4a4-4d89-bafa-6f091c272c59"));
                startActivity(solid);
                break;
            case R.id.cnc_rela:
                Intent cnc = new Intent(Intent.ACTION_VIEW);
                cnc.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/cnc.pdf?alt=media&token=f40d6c2b-48d6-4458-ac82-f1e1c3c9ea90"));
                startActivity(cnc);
                break;
            case R.id.catia_rela:
                Intent catia = new Intent(Intent.ACTION_VIEW);
                catia.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/catia.pdf?alt=media&token=86153925-f356-4da0-ba50-630de227f5b1"));
                startActivity(catia);
                break;
            case R.id.nx_rela:
                Intent nx = new Intent(Intent.ACTION_VIEW);
                nx.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/nxcam.pdf?alt=media&token=bf362583-a704-44f7-b240-da0f3344b196"));
                startActivity(nx);
                break;
            case R.id.autocad_rela:
                Intent autocad = new Intent(Intent.ACTION_VIEW);
                autocad.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/autocad.pdf?alt=media&token=61830da5-bb39-4377-8d8f-7f1a1600d568"));
                startActivity(autocad);
                break;
            default:
                break;
        }
    }
}

