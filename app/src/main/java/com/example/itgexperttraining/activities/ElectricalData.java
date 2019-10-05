package com.example.itgexperttraining.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.itgexperttraining.R;

public class ElectricalData extends AppCompatActivity implements View.OnClickListener {
    TextView networking, plc, embedded, robotics, matlab, sap, telecom, iot;
    Toolbar toolbar;
    RelativeLayout layout_network, layout_plc, layout_matlab, layout_embedded, layout_telecom, layout_iot, layout_robot;
    Button btn_net, btn_plc, btn_matlab, btn_embedded, btn_tele, btn_iot, btn_robot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrical_data);
        networking = findViewById(R.id.textnet);
        plc = findViewById(R.id.textplc);
        embedded = findViewById(R.id.embedtext);
        robotics = findViewById(R.id.textrobotics);
        matlab = findViewById(R.id.textmat);
        sap = findViewById(R.id.textsap);
        telecom = findViewById(R.id.texttele);
        iot = findViewById(R.id.textiot);
        btn_embedded = findViewById(R.id.button_embedded);
        btn_iot = findViewById(R.id.button_internet);
        btn_matlab = findViewById(R.id.button_mat);
        btn_net = findViewById(R.id.button_net);
        btn_plc = findViewById(R.id.button_plc);
        btn_robot = findViewById(R.id.button_robotics);
        btn_tele = findViewById(R.id.button_tele);
        toolbar = findViewById(R.id.action_electrical);
        layout_embedded = findViewById(R.id.system_rela);
        layout_iot = findViewById(R.id.internet_rela);
        layout_matlab = findViewById(R.id.matlab_rela);
        layout_network = findViewById(R.id.net_rela);
        layout_plc = findViewById(R.id.plc_rela);
        layout_robot = findViewById(R.id.robot_rela);
        layout_telecom = findViewById(R.id.tele_rela);
        layout_telecom.setOnClickListener(this);
        layout_robot.setOnClickListener(this);
        layout_plc.setOnClickListener(this);
        layout_network.setOnClickListener(this);
        layout_matlab.setOnClickListener(this);
        layout_iot.setOnClickListener(this);
        layout_embedded.setOnClickListener(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.system_rela:
                Intent embedded = new Intent(Intent.ACTION_VIEW);
                embedded.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/Embedded%20Systems%20Design.pdf?alt=media&token=17860f09-adf8-4c9f-86aa-cbb7c69013f3"));
                /*embedded.putExtra("embedded ")*/
                startActivity(embedded);
                break;
            case R.id.internet_rela:
                Intent internet = new Intent(Intent.ACTION_VIEW);
                internet.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/internet_of_things_tutorial.pdf?alt=media&token=0b000113-ccbc-4573-be8f-b9c7c229456d"));
                startActivity(internet);
                break;
            case R.id.matlab_rela:
                Intent mat = new Intent(Intent.ACTION_VIEW);
                mat.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/matlab.pdf?alt=media&token=20698514-833e-4846-9cd0-e08e363355d3"));
                startActivity(mat);
                break;
            case R.id.net_rela:
                Intent network = new Intent(Intent.ACTION_VIEW);
                network.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/networking.pdf?alt=media&token=ca30b9bb-0efd-42b7-b76b-553cb8e18a98"));
                startActivity(network);
            case R.id.plc_rela:
                Intent plc = new Intent(Intent.ACTION_VIEW);
                plc.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/Basics_of_PLC_Programming.pdf?alt=media&token=6242c1bb-328e-4ffb-8bb5-b337877d6a61"));
                startActivity(plc);
                break;
            case R.id.robot_rela:
                Intent robot = new Intent(Intent.ACTION_VIEW);
                robot.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/Intro2Robotics.pdf?alt=media&token=8102468a-fa04-4a1e-a9a0-4f4e07d34801"));
                startActivity(robot);
                break;
            case R.id.tele_rela:
                Intent tele = new Intent(Intent.ACTION_VIEW);
                tele.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/telecom.pdf?alt=media&token=2a048513-8c84-4191-8ba6-2d09ff599d67"));
                startActivity(tele);
                ;
                break;
            default:
                break;
        }

    }
}