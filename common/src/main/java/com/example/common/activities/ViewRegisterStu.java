package com.example.common.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.common.R;
import com.example.common.adapter.StudentAdapter;
import com.example.common.adapter.ViewHeading;
import com.example.common.bean.StudentBean;
import com.example.common.context.ApplicationContext;
import com.example.common.database.MyDbHelper;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class ViewRegisterStu extends AppCompatActivity {
    Toolbar toolbar;
    ProgressDialog progressBar;
    DatabaseReference mDatabaseReference;
    RecyclerView recyclerView1, recyclerView2;
    ArrayList stname =  new ArrayList();
    ArrayList name = new ArrayList(Arrays.asList("Sr.no.","Name","Father Name","Email","Phno.","Course","Branch","Interested","Reference"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_register_stu);
        toolbar = (Toolbar) findViewById(R.id.toolbar_view);
        recyclerView1 = (RecyclerView)findViewById(R.id.recycler_heading);
        recyclerView2 = (RecyclerView)findViewById(R.id.recycler_values);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ViewRegisterStu.this,16);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(ViewRegisterStu.this,16);
        recyclerView2.setLayoutManager(gridLayoutManager2);
        recyclerView1.setLayoutManager(gridLayoutManager);
        ViewHeading viewHeading = new ViewHeading(getApplicationContext(),name);
        recyclerView1.setAdapter(viewHeading);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Student");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mDatabaseReference.child("Student").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                stname.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    StudentBean studentBean = dataSnapshot1.getValue(StudentBean.class);
                    stname.add(studentBean);
                    mDatabaseReference.child("Student").push().setValue(stname);
                }
                StudentAdapter viewHeading = new StudentAdapter(getApplicationContext(),stname);
                recyclerView2.setAdapter(viewHeading);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        /*progressBar = new ProgressDialog(ViewRegisterStu.this);
        progressBar.setCancelable(false);
        progressBar.setMessage("Fetching Students..");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();*/

    }
}