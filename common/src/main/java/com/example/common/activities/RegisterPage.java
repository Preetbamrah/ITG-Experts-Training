package com.example.common.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.common.R;

public class RegisterPage extends AppCompatActivity {
EditText editText1,editText2,editText3,editText4;
Button button;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        editText1 = findViewById(R.id.reguser);
        editText2 = findViewById(R.id.regemail);
        editText3 = findViewById(R.id.regpass);
        editText4 = findViewById(R.id.regpassre);
        button = findViewById(R.id.signupbtn);
        textView = findViewById(R.id.text_login);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterPage.this, LoginPage.class);
                startActivity(intent);
            }
        });

    }
}
