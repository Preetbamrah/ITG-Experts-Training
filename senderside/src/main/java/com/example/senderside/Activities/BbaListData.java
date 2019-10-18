package com.example.senderside.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.senderside.R;
import com.example.senderside.adapter.BbaAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class BbaListData extends AppCompatActivity {
Toolbar toolbar;
ArrayList image = new ArrayList(Arrays.asList(R.drawable.marketing,R.drawable.dmarketing,R.drawable.finance,R.drawable.hr,R.drawable.seotrans,R.drawable.accounting,R.drawable.tally));
ArrayList name = new ArrayList(Arrays.asList("MARKETING","DIGITAL MARKETING","FINANCE","HR","SEO","ACCOUNTING","TALLY"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bba_list_data);
        toolbar = (Toolbar)findViewById(R.id.toolbar_bba);
        RecyclerView bbaRecycler = (RecyclerView)findViewById(R.id.bba_recycler);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                finish();
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        bbaRecycler.setLayoutManager(layoutManager);
        BbaAdapter bbaAdapter = new BbaAdapter(getApplicationContext(),image,name);
        bbaRecycler.setAdapter(bbaAdapter);
    }
}
