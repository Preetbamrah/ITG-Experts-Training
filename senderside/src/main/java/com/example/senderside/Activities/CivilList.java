package com.example.senderside.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.senderside.R;
import com.example.senderside.adapter.CivilAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class CivilList extends AppCompatActivity {

    Toolbar toolbar;
    ArrayList image = new ArrayList(Arrays.asList(R.drawable.autocad, R.drawable.staadpro,R.drawable.revita, R.drawable.dsmax));
    ArrayList  name = new ArrayList(Arrays.asList("AUTOCAD","STAAD PRO","REVIT ARCHITECTURE","3DS-MAX"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil_list);
        toolbar = (Toolbar)findViewById(R.id.civil_toolbar);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.civil_recycler);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                finish();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        CivilAdapter civilAdapter = new CivilAdapter(getApplicationContext(),image,name);
        recyclerView.setAdapter(civilAdapter);
    }
}
