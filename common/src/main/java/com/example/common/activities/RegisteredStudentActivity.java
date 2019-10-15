package com.example.common.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.common.R;

public class RegisteredStudentActivity extends AppCompatActivity implements  View.OnClickListener{
Toolbar toolbar;
TextView registered_txt,job_registered_stu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_student);
        registered_txt = (TextView)findViewById(R.id.register_student_txt);
        job_registered_stu = (TextView)findViewById(R.id.job_registered);
        registered_txt.setOnClickListener(this);
        job_registered_stu.setOnClickListener(this);
        toolbar = findViewById(R.id.toolbar_registered);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void onClick(View view)
    {
        int i = view.getId();
        switch (i)
        {
            case R.id.register_student_txt:
                Intent student  = new Intent(RegisteredStudentActivity.this,ViewRegisterStudent.class);
                startActivity(student);
            case R.id.job_registered:
                Intent employee  = new Intent(RegisteredStudentActivity.this,ViewRegisterStudent.class);
                startActivity(employee);
            default:
                break;
        }
    }
}
