package com.example.common.activities;

import android.content.DialogInterface;
import android.content.Intent;
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

import com.example.common.R;
import com.example.common.bean.StudentBean;
import com.example.common.database.MyDbHelper;

import java.util.ArrayList;
import java.util.Calendar;

public class StudentRegistration extends AppCompatActivity {
   Spinner batch_from_spinner,batch_to_spinner,branch_spinner,course_spinner;
   Button buttonreg;
    boolean[] checkedItems;
    TextView edit_batch_from;
    EditText editTextst,editTextfa,editTextadd,editTextcon,edit_roll,editTextem,editTextsem,edit_interest,edit_reference,editOther,edit_college;
    String[] course = {"Select Course","B.Tech","HM","BBA","MCA","IT","B.COM","Other"};
    String[] branch = {"Select Branch","CSE","EE","ECE","ME","CE","IT","NO ONE"};
    final String[] interested = {"Java", "Python", "Android", "Php", "C", "C++", "Networking", "3DS-MAX", "Autocad", "Revit Architecture Structure", "Staad-Pro","Marketing","Digital Marketing","Finance","HR","SEO","Accounting","Tally","Telecom","Robotics","Embedded System","PLC/SCADA","MATLAB","IOT","Solid Work","Catia","CNC","NX CAD/CAM"};
    Toolbar toolbar;
    String batch_from,batch_to,courseSt,branchSt,interest;
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
                String interested = edit_interest.getText().toString();
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
               else if (interest.isEmpty())
                {
                    edit_interest.setError("Enter your Semester");
                    edit_interest.requestFocus();
                }
                else {

                    StudentBean studentBean = new StudentBean();

                    studentBean.setStudentName(name);
                    studentBean.setStudentFatherName(fatherName);
                    studentBean.setStudentAddress(address);
                    studentBean.setStudentEmail(emailAddress);
                    studentBean.setStudentContact(contact);
                    studentBean.setStudentOtherContact(otherContact);
                    studentBean.setStudentCollege(college);
                    studentBean.setStudentRollno(rollno);
                    studentBean.setStudentBranch(branchSt);
                    studentBean.setStudentCourse(courseSt);
                    studentBean.setStudentBatch(batch_from);
                    studentBean.setStudentBatch(batch_to);
                    studentBean.setStudentSem(semester);
                    studentBean.setStudentReference(reference);

                    MyDbHelper dbAdapter= new MyDbHelper(StudentRegistration.this);
                    dbAdapter.addStudent(studentBean);

                    Intent intent =new Intent(StudentRegistration.this,ReferencedFragment.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "student added successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });
        edit_interest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDilaogBuilder = new AlertDialog.Builder(StudentRegistration.this);
                alertDilaogBuilder.setTitle("Choose Courses")
                        .setMultiChoiceItems(interested, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int selectedItemId, boolean isSelected) {
                                if (isSelected) {
                                    if (!interestArray.contains(selectedItemId))
                                    {
                                        interestArray.add(selectedItemId);
                                    }
                                } else if (interestArray.contains(selectedItemId)) {
                                    interestArray.remove(Integer.valueOf(selectedItemId));
                                }
                            }
                        })
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                String items = "";
                                for (int i = 0;i< interestArray.size();i++)
                                {
                                    items = items+interested[interestArray.get(i)];
                                    if (i!= interestArray.size() -1)
                                    {
                                        items = items+ ",";
                                    }
                                }
                                edit_interest.setText(items);
                               /* Intent intent = new Intent(Intent.ACTION_VIEW);
                                startActivity(intent);*/
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                               dialogInterface.dismiss();
                            }
                        });
                AlertDialog alertDialog  = alertDilaogBuilder.create();
                alertDialog.show();
            }
        });
    }
}
