package com.example.senderside.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.senderside.R;
import com.example.senderside.adapter.ElectricalAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class EclectricalList extends AppCompatActivity {
    Toolbar toolbar;
    ArrayList images = new ArrayList(Arrays.asList(R.drawable.networking,R.drawable.scada,R.drawable.matlabtrans,R.drawable.embedded,R.drawable.telecompng,R.drawable.iot,R.drawable.robottrans,R.drawable.sappng));
    ArrayList name = new ArrayList(Arrays.asList("NETWORKING","PLC/SCADA","MATLAB","EMBEDDED SYSTEM","TELECOM","INTERNET OF THINGS","ROBOTICS","SAP"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eclectrical_list);
        toolbar =  (Toolbar)findViewById(R.id.toolbar_electrical);
        RecyclerView electricalRecycler = (RecyclerView)findViewById(R.id.electrical_recycler);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        electricalRecycler.setLayoutManager(linearLayoutManager);
        ElectricalAdapter electricalAdapter = new ElectricalAdapter(getApplicationContext(),images,name);
        electricalRecycler.setAdapter(electricalAdapter);
    }
}
