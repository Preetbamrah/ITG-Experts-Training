package com.example.itgexperttraining.activities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.itgexperttraining.R;
import com.google.android.gms.flags.Flag;

import java.util.ArrayList;
import java.util.Calendar;

public class CreateResume extends AppCompatActivity {
    private static   final String TAB = "CreateResume";
    private EditText mDisplayDate, mLanguageDetail,mtechical,mOther;
    private DatePickerDialog.OnDateSetListener mDateSetListenenr;
    AutoCompleteTextView graduatinAuto;
    Toolbar toolbar;
    String[] languages = {"Punjabi","Hindi","English","Other"};
    String[] graduationList = {"B.tech(ME)","B.tech(CSE)","B.tech(EE)","B.tech(ECE)","B.tech(CE)","B.tech(IT)","BBA","BCA","B.Com","M.Com","MBA","MCA"};
    String[] technicalSkill = {"Java", "Python", "Android", "Php", "C", "C++", "Networking", "3DS-MAX", "Autocad", "Revit Architecture Structure", "Staad-Pro","Telecom","Robotics","Embedded System","PLC/SCADA","MATLAB","IOT","Solid Work","Catia","CNC","NX CAD/CAM"};
    String[] otherSkill = {"Marketing","Digital Marketing","Finance","HR","SEO","Accounting","Tally","Communication Skill","Professtional Skill","Creativity","Any Other"};
    boolean[] seletedItems,selectTechnicalItems,selectOtherItems;
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
        mLanguageDetail = (EditText)findViewById(R.id.language_detail);
        mtechical  = (EditText) findViewById(R.id.technical_auto_edit);
        mOther = (EditText) findViewById(R.id.other_skill_edit);
        graduatinAuto = (AutoCompleteTextView)findViewById(R.id.graduation_auto_complete);
        toolbar = findViewById(R.id.toolbar_resume);
        final ArrayList<Integer> technicalArray = new ArrayList<>();
        final ArrayList<Integer> otherArray = new ArrayList<>();
        ArrayAdapter<String> graduationArray = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,graduationList);
        graduatinAuto.setAdapter(graduationArray);
        graduatinAuto.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                graduatinAuto.showDropDown();
                return false;
            }
        });
        seletedItems = new boolean[languages.length];
        selectTechnicalItems = new boolean[technicalSkill.length];
        selectOtherItems = new boolean[otherSkill.length];
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
        mtechical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CreateResume.this);
                alertDialogBuilder.setTitle("Choose Technical Skill")
                        .setMultiChoiceItems(technicalSkill, selectTechnicalItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int selectedId, boolean isSelected) {
                                if (isSelected)
                                {
                                    if (!technicalArray.contains(selectedId))
                                    {
                                        technicalArray.add(selectedId);
                                    }
                                }
                                else {
                                    if (technicalArray.contains(selectedId))
                                    {
                                        technicalArray.remove(Integer.valueOf(selectedId));
                                    }
                                }
                            }
                        })
                        .setCancelable(false)
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                String items = "";
                                for (int i=0;i<technicalArray.size();i++)
                                {
                                    items = items
                                            +technicalSkill[technicalArray.get(i)];
                                    if (i!= technicalArray.size() -1)
                                    {
                                        items = items+ ",";
                                    }
                                }
                                mtechical.setText(items);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        mOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(CreateResume.this);
                alertDialog.setTitle("Select Skill")
                        .setMultiChoiceItems(otherSkill, selectOtherItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int selectedId, boolean isSelect) {
                                if (isSelect)
                                {
                                    if (!otherArray.contains(selectedId))
                                    {
                                        otherArray.add(selectedId);
                                    }
                                }
                                else {
                                    if (otherArray.contains(selectedId))
                                    {
                                        otherArray.remove(selectedId);
                                    }
                                }
                            }
                        })
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                String items = "";
                                for (int i = 0; i < otherArray.size(); i++) {
                                    items = items + otherSkill[otherArray.get(i)];
                                    if (i != otherArray.size() - 1) {
                                        items = items + ",";
                                    }
                                }
                                mOther.setText(items);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });
        final ArrayList<Integer> languageArrayList = new ArrayList<>();
        mLanguageDetail.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CreateResume.this);
                alertDialogBuilder.setTitle("Choose Language")
                        .setMultiChoiceItems(languages, seletedItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int selectedItemId, boolean isSelected) {
                              if(isSelected)
                              {
                                  if (!languageArrayList.contains(selectedItemId))
                                  {
                                      languageArrayList.add(selectedItemId);
                                  }
                              }
                              else {
                                  if (languageArrayList.contains(selectedItemId))
                                  {
                                      languageArrayList.remove(Integer.valueOf(selectedItemId));
                                  }
                              }
                            }
                        })
                        .setCancelable(false)
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                String items = "";
                                for (int i = 0;i< languageArrayList.size();i++)
                                {
                                    items = items+languages[languageArrayList.get(i)];
                                    if (i!= languageArrayList.size() -1)
                                    {
                                        items = items+ ",";
                                    }
                                }
                                mLanguageDetail.setText(items);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
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
