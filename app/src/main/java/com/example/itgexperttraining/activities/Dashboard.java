package com.example.itgexperttraining.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.itgexperttraining.R;

public class Dashboard extends AppCompatActivity implements  View.OnClickListener{
   TextView textView,textBba,textmechanical,textcomputer,textee,textcon,textabout,textpro,textreg;
    Toolbar toolbar;
    RelativeLayout layout_mechanical,layout_electrical,layout_computer,layout_civil,layout_bba,layout_contact,layout_about,layout_register,layout_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        toolbar = findViewById(R.id.toolbar);
        textBba = findViewById(R.id.bba);
        textmechanical = findViewById(R.id.mechanical);
        textcomputer = findViewById(R.id.computer);
        textee = findViewById(R.id.electrical);
        textcon= findViewById(R.id.contact);
        textabout = findViewById(R.id.about);
        textpro = findViewById(R.id.profile);
        textreg = findViewById(R.id.registration);
        textView = findViewById(R.id.civil);
        layout_register = findViewById(R.id.registrationrela);
        layout_profile = findViewById(R.id.profilerel);
        layout_mechanical = findViewById(R.id.relative);
        layout_electrical = findViewById(R.id.electricalrela);
        layout_contact = findViewById(R.id.contactrel);
        layout_computer = findViewById(R.id.computerrela);
        layout_civil = findViewById(R.id.civilrela);
        layout_bba = findViewById(R.id.bbarela);
        layout_about = findViewById(R.id.aboutrela);
        layout_about.setOnClickListener(this);
        layout_bba.setOnClickListener(this);
        layout_civil.setOnClickListener(this);
        layout_computer.setOnClickListener(this);
        layout_contact.setOnClickListener(this);
        layout_electrical.setOnClickListener(this);
        layout_mechanical.setOnClickListener(this);
        layout_profile.setOnClickListener(this);
        layout_register.setOnClickListener(this);
    }
    public  void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.relative:
                Intent mechanical = new Intent(Dashboard.this, MechanicalData.class);
                startActivity(mechanical);
                break;
            case R.id.electricalrela:
                Intent electrical = new Intent(Dashboard.this, ElectricalData.class);
                startActivity(electrical);
                break;
            case R.id.computerrela:
                 Intent computer = new Intent(Dashboard.this, ComputerData.class);
                 startActivity(computer);
                 break;
            case R.id.civilrela:
                Intent civil = new Intent(Dashboard.this, CivilData.class);
                startActivity(civil);
                break;
            case R.id.bbarela:
                Intent bba = new Intent(Dashboard.this, BbaData.class);
                startActivity(bba);
                break;
            case R.id.contactrel:
                Intent contact = new Intent(Dashboard.this, ContactActivity.class);
                startActivity(contact);
                break;
            case R.id.aboutrela:
                Intent about = new Intent(Dashboard.this, AboutActivity.class);
                startActivity(about);
                break;
            case R.id.registrationrela:
                 Intent registration = new Intent(Dashboard.this,RegistrationForm.class);
                 startActivity(registration);
                 break;
            case R.id.profilerel:
                Intent  profile = new Intent(Dashboard.this, ProfileDetail.class);
                startActivity(profile);
                break;
            default:
                break;

        }
    }

}

