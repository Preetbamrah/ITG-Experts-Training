package com.example.itgexperttraining.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.itgexperttraining.R;

public class RegistrationForm extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
Button student_reg_btn,job_reg_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        student_reg_btn = findViewById(R.id.register_btn);
        toolbar = findViewById(R.id.registration_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        job_reg_btn = findViewById(R.id.job_register_btn);
        student_reg_btn.setOnClickListener(this);
        job_reg_btn.setOnClickListener(this);

    }
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.register_btn:
                    Intent studentIntent = new Intent(RegistrationForm.this,StudentRegistration.class);
                    startActivity(studentIntent);
                break;
            case R.id.job_register_btn:
                Intent jobIntent = new Intent(RegistrationForm.this,JobRegistrationForm.class);
                startActivity(jobIntent);
                break;
                default:
                    break;
        }
    }
}
