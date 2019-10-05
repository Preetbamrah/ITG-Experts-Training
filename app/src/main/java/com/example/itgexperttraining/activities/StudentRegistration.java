package com.example.itgexperttraining.activities;

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

public class StudentRegistration extends AppCompatActivity {
    TextView textStu,textfath,textadd,textbran,textbat,textcou,textcon,textem,textsem,textin;
    Spinner spinnerbathfi,spinnerbathse,spinnerco,spinnerbran,spinnerinter;
    Button buttonreg;
    EditText editTextst,editTextfa,editTextadd,editTextcon,editTextem,editTextsem;
    String[] course = {"B.Tech","BBA","MBA","B.Com","IT"};
    String[] branch = {"CSE","EE","ECE","ME","CE"};
    String[] interested = {"Java", "Python", "Android", "Php", "C", "C++", "Networking", "3DS-MAX", "Autocad", "Revit Architecture Structure", "Staad-Pro","Marketing","Digital Marketing","Finance","HR","SEO","Accounting","Tally","Telecom","Robotics","Embedded System","PLC/SCADA","MATLAB","IOT","Solid Work","Catia","CNC","NX CAD/CAM"};
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        textStu = findViewById(R.id.student_text);
        textfath = findViewById(R.id.fathertext);
        textadd = findViewById(R.id.addresstext);
        textbat = findViewById(R.id.batchtext);
        textbran = findViewById(R.id.branchtext);
        textcon = findViewById(R.id.contacttext);
        textcou = findViewById(R.id.coursetext);
        textem = findViewById(R.id.emailtext);
        textsem = findViewById(R.id.semtext);
        textin = findViewById(R.id.interesttext);
        spinnerbathfi = findViewById(R.id.batchfirst);
        spinnerbathse = findViewById(R.id.batchsecond);
        spinnerco = findViewById(R.id.spinnercourse);
        spinnerbran = findViewById(R.id.spinnerbranch);
        buttonreg = findViewById(R.id.registerbtn);
        editTextadd = findViewById(R.id.addressedit);
        editTextst = findViewById(R.id.studentedit);
        editTextfa = findViewById(R.id.fatheredit);
        editTextcon = findViewById(R.id.contactdit);
        editTextem = findViewById(R.id.emailedit);
        editTextsem = findViewById(R.id.semedit);
        spinnerinter = findViewById(R.id.spinnerinterest);
        toolbar  = findViewById(R.id.toolbar_registration_form);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // year Spinner
        ArrayList<String> years = new ArrayList<String>();
        int thisyear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i= 2010;i<=thisyear;i++)
        {
            years.add(Integer.toString(i+1));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(StudentRegistration.this, android.R.layout.simple_spinner_dropdown_item, years);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(StudentRegistration.this,android.R.layout.simple_spinner_dropdown_item,years);
        spinnerbathfi.setAdapter(adapter);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerbathse.setAdapter(arrayAdapter);

        // course Spinner
        ArrayAdapter<String> courseArray = new ArrayAdapter<String>(StudentRegistration.this,android.R.layout.simple_spinner_dropdown_item,course);
        spinnerco.setAdapter(courseArray);

        //Branch Spinner
        ArrayAdapter<String> branchArray = new ArrayAdapter<String>(StudentRegistration.this,android.R.layout.simple_spinner_dropdown_item,branch);
        spinnerbran.setAdapter(branchArray);

        //Interested Spinner
        ArrayAdapter<String> interestArray = new ArrayAdapter<String>(StudentRegistration.this,android.R.layout.simple_spinner_dropdown_item,interested);
        spinnerinter.setAdapter(interestArray);
    }
}
