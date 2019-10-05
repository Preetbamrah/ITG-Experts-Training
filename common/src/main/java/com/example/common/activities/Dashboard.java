package com.example.common.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.common.R;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    TextView update_text, view_text, register_text, profile_text, app_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        update_text = (TextView) findViewById(R.id.update_text);
        view_text = (TextView) findViewById(R.id.view_update_text);
        register_text = (TextView) findViewById(R.id.register_text);
        profile_text = (TextView) findViewById(R.id.faculty_profile);
        app_text = (TextView)findViewById(R.id.other_app_text);
        app_text.setOnClickListener(this);
        update_text.setOnClickListener(this);
        view_text.setOnClickListener(this);
        register_text.setOnClickListener(this);
        profile_text.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update_text:
                Intent update = new Intent(Dashboard.this,StatusUpdate.class);
                startActivity(update);
                break;
            case R.id.view_update_text:
                Intent viewUpdate  = new Intent(Dashboard.this,ViewStatusActivity.class);
                startActivity(viewUpdate);
                break;
            case R.id.register_text:
                Intent registerStudent = new Intent(Dashboard.this,RegisteredStudentActivity.class);
                startActivity(registerStudent);
                break;
            case R.id.other_app_text:
                Intent appIntent = new Intent(Dashboard.this, AppActivity.class);
                startActivity(appIntent);
                break;
            case R.id.faculty_profile:
                Intent profile= new Intent(Dashboard.this,FacultyProfile.class);
                startActivity(profile);
                break;
                default:
                    break;

        }
    }
}



