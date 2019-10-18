package com.example.senderside.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.senderside.R;
import com.example.senderside.adapter.ComputerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class ComputerList extends AppCompatActivity {
Toolbar toolbar;
ArrayList image = new  ArrayList<>(Arrays.asList(R.drawable.ctrans,R.drawable.advance,R.drawable.javatra,R.drawable.android,R.drawable.networking,R.drawable.phptrans,R.drawable.transpython));
ArrayList name = new ArrayList(Arrays.asList("C","C++","JAVA","ANDROID","NETWORKING","PHP","PYTHON"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_list);
        toolbar = (Toolbar)findViewById(R.id.computer_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView computerRecycler = (RecyclerView)findViewById(R.id.computer_recycle);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        computerRecycler.setLayoutManager(linearLayoutManager);
        ComputerAdapter computerAdapter =  new ComputerAdapter(getApplicationContext(),image,name);
        computerRecycler.setAdapter(computerAdapter);
    }
}
