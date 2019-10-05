package com.example.common.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.common.R;

public class AppActivity extends AppCompatActivity implements View.OnClickListener{
Button expert_btn,development_btn;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        expert_btn = findViewById(R.id.training_app_btn);
        development_btn = findViewById(R.id.development_app_btn);
        toolbar = findViewById(R.id.toolbar_app);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

        expert_btn.setOnClickListener(this);
        development_btn.setOnClickListener(this);

    }
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.training_app_btn:
                Intent trainingIntent = getPackageManager().getLaunchIntentForPackage("com.example.senderside");
                startActivity(trainingIntent);
                break;
            case R.id.development_app_btn:
                Intent develIntent = getPackageManager().getLaunchIntentForPackage("com.example.itgexperttraining");
                startActivity(develIntent);
                break;
                default:
                    break;
        }
    }
}
