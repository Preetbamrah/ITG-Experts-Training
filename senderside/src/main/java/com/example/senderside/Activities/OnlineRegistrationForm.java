package com.example.senderside.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.senderside.R;

import java.util.ArrayList;
import java.util.Calendar;


public class OnlineRegistrationForm extends Fragment implements View.OnClickListener {
    private View view;
    private Button student_reg_btn,job_reg_btn;
    private Toolbar toolbar;
    public  OnlineRegistrationForm()
    {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_online_registration_form, container, false);
        AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();
        toolbar = view.findViewById(R.id.toolbar_registration_form);
        appCompatActivity.setSupportActionBar(toolbar);
        student_reg_btn = view.findViewById(R.id.studentregister_btn);
        job_reg_btn = view.findViewById(R.id.job_register_btn);
        student_reg_btn.setOnClickListener(this);
        job_reg_btn.setOnClickListener(this);
         return view;

    }
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.studentregister_btn:
                    Intent studentIntent = new Intent(getActivity(),StudentRegistration.class);
                    startActivity(studentIntent);
                case R.id.job_register_btn:
                    Intent jobIntent = new Intent(getActivity(),JobRegistrationForm.class);
                   startActivity(jobIntent);
            }
        }
}
