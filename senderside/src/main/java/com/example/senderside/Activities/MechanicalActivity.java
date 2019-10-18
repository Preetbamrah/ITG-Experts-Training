package com.example.senderside.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.senderside.R;
import com.example.senderside.adapter.ArrayListAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MechanicalActivity extends AppCompatActivity {
    Toolbar toolbar;
ArrayList image = new ArrayList(Arrays.asList(R.drawable.autocad,R.drawable.catiatrans,R.drawable.nxcam,R.drawable.worksolid,R.drawable.cnctr));
ArrayList name = new ArrayList(Arrays.asList("AUTOCAD","CATIA","NX CAD/CAM","SOLID WORK","CNC TURNING/ VMC"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanical);
        toolbar = (Toolbar) findViewById(R.id.mechanical_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        RecyclerView mechanicalRecycler = findViewById(R.id.mechanical_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mechanicalRecycler.setLayoutManager(linearLayoutManager);
        ArrayListAdapter arrayListAdapter = new ArrayListAdapter(getApplicationContext(),image,name);
        mechanicalRecycler.setAdapter(arrayListAdapter);
    }
}
