package com.example.itgexperttraining.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.itgexperttraining.R;

import java.util.ArrayList;
import java.util.Calendar;

public class JobRegistrationForm extends AppCompatActivity {
    TextView textStu, textfath, textadd,textcon, textem;
    Button buttonreg;
    EditText editTextst, editTextfa, editTextadd, editTextcon, editTextem,gradedit,schedit,otherconedit;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_registration_form);
        textStu = findViewById(R.id.student_text);
        textfath = findViewById(R.id.fathertext);
        textadd = findViewById(R.id.addresstext);
        textcon = findViewById(R.id.contacttext);
        textem = findViewById(R.id.emailtext);
        buttonreg = findViewById(R.id.registerbtn);
        editTextadd = findViewById(R.id.addressedit);
        editTextst = findViewById(R.id.studentedit);
        editTextfa = findViewById(R.id.fatheredit);
        editTextcon = findViewById(R.id.contactdit);
        editTextem = findViewById(R.id.emailedit);
        otherconedit = findViewById(R.id.othercontactdit);
        gradedit = findViewById(R.id.graduation_edit);
        schedit = findViewById(R.id.school_edit);
        toolbar = findViewById(R.id.toolbar_registration_form);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buttonreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progress=new ProgressDialog(JobRegistrationForm.this);
                progress.setTitle("");
                progress.setMessage("Please wait...");
                progress.setCancelable(false);
                progress.show();

                String name = editTextst.getText().toString().trim();
                String fatherName = editTextfa.getText().toString().trim();
                String address = editTextadd.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String contact = editTextcon.getText().toString();
                String contactPattern = "(0/91)?[6-9][0-9]{9}";
                String otherContact = otherconedit.getText().toString();
                String emailAddress = editTextem.getText().toString();
                String school = schedit.getText().toString().trim();
                String graduation = gradedit.getText().toString().trim();
                if (name.isEmpty())
                {
                    editTextst.setError("Enter your name");
                    editTextst.requestFocus();
                }
                if (fatherName.isEmpty())
                {
                    editTextfa.setError("Enter your Father Name");
                    editTextfa.requestFocus();
                }
                if (address.isEmpty())
                {
                    editTextadd.setError("Enter Your Address");
                    editTextadd.requestFocus();
                }
               if (emailAddress.isEmpty())
               {
                   editTextem.setError("Enter Email Address");
                   editTextem.requestFocus();
               }
               if (!emailAddress.matches(emailPattern))
               {
                   editTextem.setError("Enter valid email");
                   editTextem.requestFocus();
               }
                if (!contact.matches(contactPattern))
                {
                    editTextcon.setError("Enter Valid Contact");
                    editTextcon.requestFocus();
                }
                if (!otherContact.matches(contactPattern))
                {
                    otherconedit.setError("Enter Valid Contact");
                    otherconedit.requestFocus();
                }
                if (school.isEmpty())
                {
                    schedit.setError("Enter your School Name");
                    schedit.requestFocus();
                }
                else {
                    if (progress.isShowing())
                    {
                        progress.dismiss();
                    }
                    Intent intent = new Intent(JobRegistrationForm.this,Dashboard.class);
                    startActivity(intent);
                }

                /*if (graduation.isEmpty())
                {
                    gradedit.setError("Enter Your Qualification");
                    gradedit.requestFocus();
                }*/

            }
        });
    }
}
