package com.example.itgexperttraining.activities;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.example.itgexperttraining.R;


public class DemoActivity extends AppCompatActivity {
TextView textView;
AutoCompleteTextView autoCompleteTextView;
String[] languages = {"Hindi","Punjabi","English"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        textView = (TextView)findViewById(R.id.demo_text);
        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.demo_auto_complete);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,languages);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }
}
