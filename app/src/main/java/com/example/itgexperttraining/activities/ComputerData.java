package com.example.itgexperttraining.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.itgexperttraining.R;

public class ComputerData extends AppCompatActivity implements View.OnClickListener {
    TextView networking,php,c,advancec,python,java,android;
    Toolbar toolbar;
    RelativeLayout layout_php,layout_java,layout_android,layout_networking,layout_python,layout_c,layout_advancec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_data);
        networking = findViewById(R.id.textnetworking);
        php = findViewById(R.id.textphp);
        c = findViewById(R.id.textc);
        advancec = findViewById(R.id.textadvancec);
        python = findViewById(R.id.textpython);
        java = findViewById(R.id.textjava);
        android  = findViewById(R.id.textandroid);
        layout_advancec = findViewById(R.id.advance_rela);
        layout_android = findViewById(R.id.android_rela);
        layout_c = findViewById(R.id.c_rela);
        layout_java = findViewById(R.id.java_rela);
        layout_networking = findViewById(R.id.network_rela);
        layout_php = findViewById(R.id.php_rela);
        layout_python = findViewById(R.id.python_rela);
        layout_python.setOnClickListener(this);
        layout_php.setOnClickListener(this);
        layout_networking.setOnClickListener(this);
        layout_java.setOnClickListener(this);
        layout_c.setOnClickListener(this);
        layout_android.setOnClickListener(this);
        layout_advancec.setOnClickListener(this);
        toolbar = findViewById(R.id.action_computer);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public  void onClick(View v)
    {
            switch (v.getId())
            {
                case R.id.php_rela:
                    Intent php = new Intent(Intent.ACTION_VIEW);
                    php.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/php.pdf?alt=media&token=92410b67-ba15-4715-b9d4-afb05371e1c5"));
                    startActivity(php);
                    break;
                case R.id.java_rela:
                    Intent java = new  Intent(Intent.ACTION_VIEW);
                    java.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/java.pdf?alt=media&token=1b033352-dae8-4adf-bc87-9b289d6d558f"));
                    startActivity(java);
                    break;
                case R.id.network_rela:
                    Intent network = new Intent(Intent.ACTION_VIEW);
                    network.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/networking.pdf?alt=media&token=ca30b9bb-0efd-42b7-b76b-553cb8e18a98"));
                    startActivity(network);
                    break;
                case R.id.python_rela:
                    Intent python = new Intent(Intent.ACTION_VIEW);
                    python.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/Python.pdf?alt=media&token=8c9454b5-c140-4cfd-a81e-96274c5577b4"));
                    startActivity(python);
                    break;
                case R.id.c_rela:
                    Intent c = new Intent(Intent.ACTION_VIEW);
                    c.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/c.pdf?alt=media&token=311451a0-3c0b-46e3-bae8-496fc0bc0990"));
                    startActivity(c);
                    break;
                case R.id.android_rela:
                    Intent android = new Intent(Intent.ACTION_VIEW);
                    android.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/android.pdf?alt=media&token=562b17a2-5dfa-4df7-8496-a8813cc9fcc4"));
                    startActivity(android);
                    break;
                case R.id.advance_rela:
                    Intent advance = new Intent(Intent.ACTION_VIEW);
                    advance.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/advancec.pdf?alt=media&token=7c484ede-bea4-4f87-a5fe-9bf57025eea2"));
                    startActivity(advance);
                    break;
                    default:
                        break;

            }

    }
}