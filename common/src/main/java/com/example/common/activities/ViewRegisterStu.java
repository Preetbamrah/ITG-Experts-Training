package com.example.common.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.common.R;
import com.example.common.bean.StudentBean;
import com.example.common.context.ApplicationContext;
import com.example.common.database.MyDbHelper;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ViewRegisterStu extends AppCompatActivity {
Toolbar toolbar;
TableLayout mTableLayout;
ProgressDialog progressBar;
MyDbHelper myDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_register_stu);
        toolbar = (Toolbar)findViewById(R.id.toolbar_view);
        mTableLayout = (TableLayout)findViewById(R.id.view_student_table);
        mTableLayout.setShrinkAllColumns(true);
        myDbHelper = new MyDbHelper(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        progressBar = new ProgressDialog(ViewRegisterStu.this);
        progressBar.setCancelable(false);
        progressBar.setMessage("Fetching Students..");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();
        new LoadDataTask().execute(0);
    }

    private class LoadDataTask extends AsyncTask<Integer, Integer, String>
    {
        @Override
        protected String doInBackground(Integer... params) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task Completed.";
        }
        @Override
        protected void onPostExecute(String result) {
            progressBar.hide();
            loadData();
        }
        @Override
        protected void onPreExecute() {
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
        }
    }

    public void loadData() {
        int leftRowMargin=0;
        int topRowMargin=0;
        int rightRowMargin=0;
        int bottomRowMargin = 0;
        int textSize = 0, smallTextSize =0, mediumTextSize = 0;
        textSize = (int) getResources().getDimension(R.dimen.font_size_verysmall);
        smallTextSize = (int) getResources().getDimension(R.dimen.font_size_small);
        mediumTextSize = (int) getResources().getDimension(R.dimen.font_size_medium);
        MyDbHelper myDbHelper = new MyDbHelper(ViewRegisterStu.this);
        ArrayList<StudentBean> data = myDbHelper.getAllStudent();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy");
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        int rows = data.size();
        getSupportActionBar().setTitle("Invoices (" + String.valueOf(rows) + ")");
        TextView textSpacer = null;
        mTableLayout.removeAllViews();
        // -1 means heading row
        for(int i = -1; i < rows; i ++) {
            StudentBean row = null;
            if (i > -1)
                row = data.get(i);
            else {
                textSpacer = new TextView(this);
                textSpacer.setText("");
            }
            // data columns
            final TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.LEFT);
            tv.setPadding(5, 15, 0, 15);
            if (i == -1) {
                tv.setText("Sr.No.");
                tv.setBackgroundColor(Color.parseColor("#f0f0f0"));
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, smallTextSize);
            } else {
                tv.setBackgroundColor(Color.parseColor("#f8f8f8"));
                tv.setText(String.valueOf(row.getStudent_id()));
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            }
            final LinearLayout layStudent = new LinearLayout(this);
            layStudent.setOrientation(LinearLayout.VERTICAL);
            layStudent.setPadding(0, 10, 0, 10);
            layStudent.setBackgroundColor(Color.parseColor("#f8f8f8"));
            final TextView tv2 = new TextView(this);
            if (i == -1) {
                tv2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tv2.setTextSize(TypedValue.COMPLEX_UNIT_PX, smallTextSize);
            } else {
                tv2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.MATCH_PARENT));
                tv2.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            }
            tv2.setGravity(Gravity.TOP);
            if (i == -1) {
                tv2.setText("Name/ " +
                        "Father Name");
                tv2.setBackgroundColor(Color.parseColor("#f7f7f7"));
            }else {
                tv2.setBackgroundColor(Color.parseColor("#ffffff"));
                tv2.setTextColor(Color.parseColor("#000000"));
                tv2.setText(row.getStudent_firstname());
            }
            layStudent.addView(tv2);
            if (i > -1) {
                final TextView tv3b = new TextView(this);
                tv3b.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tv3b.setGravity(Gravity.RIGHT);
                tv3b.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                tv3b.setPadding(5, 1, 0, 5);
                tv3b.setTextColor(Color.parseColor("#00afff"));
                tv3b.setBackgroundColor(Color.parseColor("#f8f8f8"));
                tv3b.setText(row.getStudent_fathername());
                layStudent.addView(tv3b);
            }
            final LinearLayout layCustomer = new LinearLayout(this);
            layCustomer.setOrientation(LinearLayout.VERTICAL);
            layCustomer.setPadding(0, 10, 0, 10);
            layCustomer.setBackgroundColor(Color.parseColor("#f8f8f8"));
            final TextView tv3 = new TextView(this);
            if (i == -1) {
                tv3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT));
                tv3.setPadding(5, 5, 0, 5);
                tv3.setTextSize(TypedValue.COMPLEX_UNIT_PX, smallTextSize);
            } else {
                tv3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT));
                tv3.setPadding(5, 0, 0, 5);
                tv3.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            }
            tv3.setGravity(Gravity.TOP);
            if (i == -1) {
                tv3.setText("Course");
                tv3.setBackgroundColor(Color.parseColor("#f0f0f0"));
            } else {
                tv3.setBackgroundColor(Color.parseColor("#f8f8f8"));
                tv3.setTextColor(Color.parseColor("#000000"));
                tv3.setTextSize(TypedValue.COMPLEX_UNIT_PX, smallTextSize);
                tv3.setText(row.getStudent_contact());
            }
            layCustomer.addView(tv3);
            if (i > -1) {
                final TextView tv3b = new TextView(this);
                tv3b.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tv3b.setGravity(Gravity.RIGHT);
                tv3b.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                tv3b.setPadding(5, 1, 0, 5);
                tv3b.setTextColor(Color.parseColor("#aaaaaa"));
                tv3b.setBackgroundColor(Color.parseColor("#f8f8f8"));
                tv3b.setText(row.getStudent_branch());
                layCustomer.addView(tv3b);
            }

            final TextView tv7 = new TextView(this);
            if (i == -1) {
                tv7.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tv7.setTextSize(TypedValue.COMPLEX_UNIT_PX, smallTextSize);
            } else {
                tv7.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.MATCH_PARENT));
                tv7.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            }
            tv7.setGravity(Gravity.LEFT);
            tv7.setPadding(5, 15, 0, 15);
            if (i == -1) {
                tv7.setText("Interested in");
                tv7.setBackgroundColor(Color.parseColor("#f7f7f7"));
            }else {
                tv7.setBackgroundColor(Color.parseColor("#ffffff"));
                tv7.setTextColor(Color.parseColor("#000000"));
                tv7.setText(row.getStudent_interested());
            }
            final LinearLayout layAmounts = new LinearLayout(this);
            layAmounts.setOrientation(LinearLayout.VERTICAL);
            layAmounts.setGravity(Gravity.RIGHT);
            layAmounts.setPadding(0, 10, 0, 10);
            layAmounts.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT));
            final TextView tv4 = new TextView(this);
            if (i == -1) {
                tv4.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT));
                tv4.setPadding(5, 5, 1, 5);
                layAmounts.setBackgroundColor(Color.parseColor("#f7f7f7"));
            } else {
                tv4.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tv4.setPadding(5, 0, 1, 5);
                layAmounts.setBackgroundColor(Color.parseColor("#ffffff"));
            }
            tv4.setGravity(Gravity.RIGHT);
            if (i == -1) {
                tv4.setText("Contact");
                tv4.setBackgroundColor(Color.parseColor("#f7f7f7"));
                tv4.setTextSize(TypedValue.COMPLEX_UNIT_PX, smallTextSize);
            } else {
                tv4.setBackgroundColor(Color.parseColor("#ffffff"));
                tv4.setTextColor(Color.parseColor("#000000"));
                tv4.setText(row.getStudent_mobilenumber());
                tv4.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            }
            layAmounts.addView(tv4);
            if (i > -1) {
                final TextView tv4b = new TextView(this);
                tv4b.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tv4b.setGravity(Gravity.RIGHT);
                tv4b.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                tv4b.setPadding(2, 2, 1, 5);
                //due text color
                tv4b.setText(row.getStudent_course());
                tv4b.setTextColor(Color.parseColor("#00afff"));
                tv4b.setBackgroundColor(Color.parseColor("#ffffff"));
                layAmounts.addView(tv4b);
            }

            final TextView tv5 = new TextView(this);
            if (i == -1) {
                tv5.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tv5.setTextSize(TypedValue.COMPLEX_UNIT_PX, smallTextSize);
            } else {
                tv5.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.MATCH_PARENT));
                tv5.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            }
            tv5.setGravity(Gravity.LEFT);
            tv5.setPadding(5, 15, 0, 15);
            if (i == -1) {
                tv5.setText("Gmail");
                tv5.setBackgroundColor(Color.parseColor("#f7f7f7"));
            }else {
                tv5.setBackgroundColor(Color.parseColor("#ffffff"));
                tv5.setTextColor(Color.parseColor("#000000"));
                tv5.setText(row.getStudent_reference());
            }

                final TextView tv6 = new TextView(this);
                if (i == -1) {
                    tv6.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                            TableRow.LayoutParams.WRAP_CONTENT));
                    tv6.setTextSize(TypedValue.COMPLEX_UNIT_PX, smallTextSize);
                } else {
                    tv6.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.MATCH_PARENT));
                    tv6.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                }
            tv6.setGravity(Gravity.LEFT);
            tv6.setPadding(5, 15, 0, 15);
                if (i == -1) {
                    tv6.setText("Reference");
                    tv6.setBackgroundColor(Color.parseColor("#f7f7f7"));
                }else {
                    tv6.setBackgroundColor(Color.parseColor("#ffffff"));
                    tv6.setTextColor(Color.parseColor("#000000"));
                    tv6.setText(row.getStudent_sem());
                }
            final TableRow tr = new TableRow(this);
            tr.setId(i + 1);
            TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT);
            trParams.setMargins(leftRowMargin, topRowMargin, rightRowMargin, bottomRowMargin);
            tr.setPadding(0,0,0,0);
            tr.setLayoutParams(trParams);
            tr.addView(tv);
            tr.addView(layStudent);
            tr.addView(layCustomer);
            tr.addView(layAmounts);
            tr.addView(tv5);
            tr.addView(tv6);
            tr.addView(tv7);
            if (i > -1) {
                tr.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        TableRow tr = (TableRow) v;

                    }
                });
            }
            mTableLayout.addView(tr, trParams);
            if (i > -1) {
                final TableRow trSep = new TableRow(this);
                TableLayout.LayoutParams trParamsSep = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT);
                trParamsSep.setMargins(leftRowMargin, topRowMargin, rightRowMargin, bottomRowMargin);
                trSep.setLayoutParams(trParamsSep);
                TextView tvSep = new TextView(this);
                TableRow.LayoutParams tvSepLay = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT);
                tvSepLay.span = 4;
                tvSep.setLayoutParams(tvSepLay);
                tvSep.setBackgroundColor(Color.parseColor("#d9d9d9"));
                tvSep.setHeight(1);
                trSep.addView(tvSep);
                mTableLayout.addView(trSep, trParamsSep);
            }
        }
    }

}

