package com.example.common.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;

import com.example.common.R;

public class StatusUpdate extends AppCompatActivity {
Toolbar toolbar;
RadioButton btn_busy,btn_free;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_update);
        toolbar = findViewById(R.id.toolbar_update_status);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_busy = findViewById(R.id.busy_radio_btn);
        btn_free = findViewById(R.id.free_radio_btn);
    }
}
