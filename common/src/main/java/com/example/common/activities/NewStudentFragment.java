package com.example.common.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class NewStudentFragment extends Fragment {
    Spinner batch_from_spinner, batch_to_spinner, branch_spinner, course_spinner;
    Button buttonreg;
    boolean[] checkedItems;
    TextView edit_batch_from;
    EditText editTextst, editTextfa, editTextadd, editTextcon, edit_roll, editTextem, editTextsem, edit_interest, editOther, edit_college;
    String[] course = {"Select Course", "B.Tech", "HM", "BBA", "MCA", "IT", "B.COM", "Other"};
    String[] branch = {"Select Branch", "CSE", "EE", "ECE", "ME", "CE", "IT", "NO ONE"};
    Toolbar toolbar;
    String batch_from, batch_to, courseSt, branchSt;

    public NewStudentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_student, container, false);
        buttonreg = view.findViewById(R.id.registerbtn_stu);
        editTextadd = view.findViewById(R.id.addressedit);
        editTextst = view.findViewById(R.id.studentedit);
        editTextfa = view.findViewById(R.id.fatheredit);
        editTextcon = view.findViewById(R.id.contactdit);
        edit_roll = (EditText) view.findViewById(R.id.rollno);
        editOther = (EditText) view.findViewById(R.id.editOther);
        editTextem = view.findViewById(R.id.emailedit);
        editTextsem = view.findViewById(R.id.semedit);
        edit_college = (EditText) view.findViewById(R.id.college);
        edit_interest = view.findViewById(R.id.interest_edit);
        batch_to_spinner = (Spinner) view.findViewById(R.id.batch_to_spinner);
        branch_spinner = (Spinner) view.findViewById(R.id.branch_spinner);
        course_spinner = (Spinner) view.findViewById(R.id.course_spinner);
        batch_from_spinner = (Spinner) view.findViewById(R.id.batch_from_spinner);
        // year Spinner
        ArrayList<String> years = new ArrayList<String>();
        int thisyear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2009; i <= thisyear; i++) {
            years.add(Integer.toString(i + 3));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, years);
        batch_to_spinner.setAdapter(arrayAdapter);
        batch_from_spinner.setAdapter(arrayAdapter);
        ArrayAdapter courseAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, course);
        course_spinner.setAdapter(courseAdapter);
        ArrayAdapter branchAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, branch);
        branch_spinner.setAdapter(branchAdapter);
        //Interested Spinner
        final ArrayList<Integer> interestArray = new ArrayList<>();//<String>(StudentRegistration.this,android.R.layout.simple_spinner_dropdown_item,interested);
        //  spinnerinter.setAdapter(interestArray);
        batch_from_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                //((TextView) arg0.getChildAt(0)).setTextColor(Color.BLACK);
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
                //((TextView) arg0.getChildAt(0)).setTextColor(Color.BLACK);
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
                //((TextView) arg0.getChildAt(0)).setTextColor(Color.BLACK);
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
                //((TextView) arg0.getChildAt(0)).setTextColor(Color.BLACK);
                branchSt = (String) branch_spinner.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        buttonreg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
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
                String semester = editTextsem.getText().toString().trim();
                String interestedin = edit_interest.getText().toString().trim();
                if (name.isEmpty()) {
                    editTextst.setError("Enter your name");
                    editTextst.requestFocus();
                } else if (fatherName.isEmpty()) {
                    editTextfa.setError("Enter your Father Name");
                    editTextfa.requestFocus();
                } else if (address.isEmpty()) {
                    editTextadd.setError("Enter Your Address");
                    editTextadd.requestFocus();
                } else if (emailAddress.isEmpty()) {
                    editTextem.setError("Enter Email Address");
                    editTextem.requestFocus();
                } else if (!emailAddress.matches(emailPattern)) {
                    editTextem.setError("Enter valid email");
                    editTextem.requestFocus();
                } else if (!contact.matches(contactPattern)) {
                    editTextcon.setError("Enter Valid Contact");
                    editTextcon.requestFocus();
                } else if (!otherContact.matches(contactPattern)) {
                    editOther.setError("Enter Valid Contact");
                    editOther.requestFocus();
                } else if (college.isEmpty()) {
                    edit_college.setError("Enter your College Name");
                    edit_college.requestFocus();
                } else if (rollno.isEmpty()) {
                    edit_roll.setError("Enter your Semester");
                    edit_roll.requestFocus();
                } else if (interestedin.isEmpty()) {
                    edit_interest.setError("Please enter interested course");
                    edit_interest.requestFocus();
                } else if (semester.isEmpty()) {
                    editTextsem.setError("Enter your Semester");
                    editTextsem.requestFocus();
                } else {

                    /*StudentBean studentBean = new StudentBean(name, fatherName, address, emailAddress, college, contact, otherContact, rollno, reference, semester, interestedin, batch_from, batch_to, branchSt, courseSt);

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
                    studentBean.setStudent_rollno(rollno);
                    studentBean.setStudent_interested(interestedin);
                    studentBean.setStudent_email(emailAddress);
                    studentBean.setStudent_sem(semester);


                    MyDbHelper dbAdapter = new MyDbHelper(getActivity());
                    dbAdapter.addStudent(studentBean);

                    *//*Intent intent =new Intent(StudentRegistration.this,ReferencedFragment.class);
                    startActivity(intent);*/
                    Toast.makeText(getContext(), "student added successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });
        return view;
    }
}