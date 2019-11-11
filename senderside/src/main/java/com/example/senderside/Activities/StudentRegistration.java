package com.example.senderside.Activities;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.senderside.Bean.StudentBean;
import com.example.senderside.R;
import com.example.senderside.database.MyDatabase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class StudentRegistration extends AppCompatActivity {
   /* TextView textStu,textfath,textadd,textbran,textbat,textcou,textcon,textem,textsem,textin;
    Spinner spinnerbathfi,spinnerbathse,spinnerco,spinnerbran;
   */
   Spinner batch_from_spinner,batch_to_spinner,branch_spinner,course_spinner;
    Button buttonreg;
    boolean[] checkedItems;
    StudentBean studentBean;
    DatabaseReference mDatabaseReference;
    FirebaseAuth firebaseAuth;
    TextView edit_batch_from;
    EditText editTextst,editTextfa,editTextadd,editTextcon,edit_roll,editTextem,editTextsem,edit_interest,edit_reference,editOther,edit_college;
    String[] course = {"Select Course","B.Tech","HM","BBA","MCA","IT","B.COM","Other"};
    String[] branch = {"Select Branch","CSE","EE","ECE","ME","CE","IT","NO ONE"};
    final String[] interested = {"Java", "Python", "Android", "Php", "C", "C++", "Networking", "3DS-MAX", "Autocad", "Revit Architecture Structure", "Staad-Pro","Marketing","Digital Marketing","Finance","HR","SEO","Accounting","Tally","Telecom","Robotics","Embedded System","PLC/SCADA","MATLAB","IOT","Solid Work","Catia","CNC","NX CAD/CAM"};
    Toolbar toolbar;
    String batch_from,batch_to,courseSt,branchSt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        buttonreg = findViewById(R.id.registerbtn_stu);
        editTextadd = findViewById(R.id.addressedit);
        editTextst = findViewById(R.id.studentedit);
        editTextfa = findViewById(R.id.fatheredit);
        editTextcon = findViewById(R.id.contactdit);
        edit_roll = (EditText)findViewById(R.id.rollno);
        editOther = (EditText)findViewById(R.id.editOther);
        editTextem = findViewById(R.id.emailedit);
        editTextsem = findViewById(R.id.semedit);
        edit_college = (EditText)findViewById(R.id.college);
        edit_interest = findViewById(R.id.interest_edit);
        edit_reference = (EditText)findViewById(R.id.referenceedit);
        batch_to_spinner = (Spinner)findViewById(R.id.batch_to_spinner);
        branch_spinner = (Spinner)findViewById(R.id.branch_spinner);
        course_spinner = (Spinner)findViewById(R.id.course_spinner);
        batch_from_spinner = (Spinner)findViewById(R.id.batch_from_spinner);
        firebaseAuth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Student");
        toolbar  = findViewById(R.id.toolbar_registration_form);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        checkedItems =  new boolean[interested.length];
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // year Spinner
        ArrayList<String> years = new ArrayList<String>();
        int thisyear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i= 2009;i<=thisyear;i++)
        {
            years.add(Integer.toString(i+3));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(StudentRegistration.this,android.R.layout.simple_spinner_dropdown_item,years);
        batch_to_spinner.setAdapter(arrayAdapter);
        batch_from_spinner.setAdapter(arrayAdapter);
        ArrayAdapter courseAdapter = new ArrayAdapter(StudentRegistration.this,android.R.layout.simple_spinner_dropdown_item,course);
        course_spinner.setAdapter(courseAdapter);
        ArrayAdapter branchAdapter = new ArrayAdapter(StudentRegistration.this,android.R.layout.simple_spinner_dropdown_item,branch);
        branch_spinner.setAdapter(branchAdapter);
        //Interested Spinner
        final ArrayList<Integer> interestArray = new ArrayList<>();//<String>(StudentRegistration.this,android.R.layout.simple_spinner_dropdown_item,interested);
        //  spinnerinter.setAdapter(interestArray);
        batch_from_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.BLACK);
                batch_from = (String) batch_from_spinner.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        batch_to_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.BLACK);
                batch_to = (String) batch_to_spinner.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        course_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.BLACK);
                courseSt = (String) course_spinner.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        branch_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.BLACK);
                branchSt = (String) branch_spinner.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });



        buttonreg.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view)
            {
                String name = editTextst.getText().toString().trim();
                String fatherName = editTextfa.getText().toString().trim();
                String address = editTextadd.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String contact = editTextcon.getText().toString();
                String contactPattern = "(0/91)?[6-9][0-9]{9}";
                String college = edit_college.getText().toString();
                String emailAddress = editTextem.getText().toString();
                String otherContact = editOther.getText().toString();
                String rollno = edit_roll.getText().toString();
                String reference = edit_reference.getText().toString();
                String semester = editTextsem.getText().toString().trim();
                String interestedin = edit_interest.getText().toString().trim();
                if (name.isEmpty())
                {
                    editTextst.setError("Enter your name");
                    editTextst.requestFocus();
                }
                else if (fatherName.isEmpty())
                {
                    editTextfa.setError("Enter your Father Name");
                    editTextfa.requestFocus();
                }
                else if (address.isEmpty())
                {
                    editTextadd.setError("Enter Your Address");
                    editTextadd.requestFocus();
                }
                else if (emailAddress.isEmpty())
                {
                    editTextem.setError("Enter Email Address");
                    editTextem.requestFocus();
                }
                else if (!emailAddress.matches(emailPattern))
                {
                    editTextem.setError("Enter valid email");
                    editTextem.requestFocus();
                }
                else if (!contact.matches(contactPattern))
                {
                    editTextcon.setError("Enter Valid Contact");
                    editTextcon.requestFocus();
                }
                else if (!otherContact.matches(contactPattern))
                {
                    editOther.setError("Enter Valid Contact");
                    editOther.requestFocus();
                }
                else if (college.isEmpty())
                {
                    edit_college.setError("Enter your College Name");
                    edit_college.requestFocus();
                }
                else if (rollno.isEmpty())
                {
                    edit_roll.setError("Enter your Semester");
                    edit_roll.requestFocus();
                }
                else if (interestedin.isEmpty())
                {
                    edit_interest.setError("Please enter interested course");
                    edit_interest.requestFocus();
                }
                else if (semester.isEmpty())
                {
                    editTextsem.setError("Enter your Semester");
                    editTextsem.requestFocus();
                }
                else if (reference.isEmpty())
                {
                    edit_reference.setError("Enter your Semester");
                    edit_reference.requestFocus();
                }
                else {
                    studentBean.setStudent_firstname(name);
                    studentBean.setStudent_fathername(fatherName);
                    studentBean.setStudent_mobilenumber(contact);
                    studentBean.setStudent_address(address);
                    studentBean.setStudent_batch_from(batch_from);
                    studentBean.setStudent_batch_to(batch_to);
                    studentBean.setStudent_branch(branchSt);
                    studentBean.setStudent_college(college);
                    studentBean.setStudent_course(courseSt);
                    studentBean.setStudent_contact(otherContact);
                    studentBean.setStudent_reference(reference);
                    studentBean.setStudent_rollno(rollno);
                    studentBean.setStudent_interested(interestedin);
                    studentBean.setStudent_email(emailAddress);
                    studentBean.setStudent_sem(semester);
                    mDatabaseReference.push().setValue(studentBean);

                    Toast.makeText(StudentRegistration.this,"Registration Successful",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
