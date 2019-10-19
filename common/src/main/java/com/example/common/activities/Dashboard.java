package com.example.common.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.common.R;
import com.example.common.adapter.DashboardAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class Dashboard extends AppCompatActivity {
Toolbar toolbar;
RecyclerView recyclerView;
ArrayList image = new ArrayList(Arrays.asList(R.drawable.register,R.drawable.eye_icon,R.drawable.user));
ArrayList name = new ArrayList(Arrays.asList("Registration Form","View Register Student","Profile"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        toolbar = (Toolbar)findViewById(R.id.toolbar_dashboard);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_dashboard);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Dashboard.this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        DashboardAdapter dashboardAdapter  = new DashboardAdapter(getApplicationContext(),image,name);
        recyclerView.setAdapter(dashboardAdapter);


    }

}



