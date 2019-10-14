package com.example.itgexperttraining.activities;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.itgexperttraining.R;

import java.util.Calendar;

public class CreateResume extends AppCompatActivity {
    private static   final String TAB = "CreateResume";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListenenr;
    Button button;
RadioGroup radioGroup;
RadioButton male_radio,female_radio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_resume);
        radioGroup = findViewById(R.id.radio_group);
        male_radio = findViewById(R.id.mail_radio_btn);
        female_radio = findViewById(R.id.female_radio_btn);
        mDisplayDate = findViewById(R.id.calender_edit);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int date = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        CreateResume.this,
                        android.R.style.Theme_Material_Light_Dialog_Alert,
                        mDateSetListenenr,
                        year,month,date
                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
            }
        });
        mDateSetListenenr = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month +1;
                Log.d(TAB,"onDateSet:"+ month+"/"+day+"/"+"/"+ year);
                String date = month+"/"+ day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
        }
}
