package com.example.itgexperttraining.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.itgexperttraining.R;

public class LoginPage extends AppCompatActivity {
    EditText et1,et2;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        et1 = findViewById(R.id.logemail);
        et2 = findViewById(R.id.logpassword);
        button = findViewById(R.id.loginbtn);
        textView = findViewById(R.id.logreg);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=et1.getText().toString();
                String password=et2.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (email.equals("")) {

                    et1.setError("Email can't be blank");
                    et1.requestFocus();
                } else if (email.equals(emailPattern)) {
                    et1.setError("Please enter the correct pattern");
                    et1.requestFocus();

                }
                else if (password.equals(""))
                {
                    et2.setError("Password can't be balnk");
                    et2.requestFocus();
                }
                Intent intent = new Intent(LoginPage.this, Dashboard.class);
                startActivity(intent);
                /*else {
                    login(email, password);
                }*/
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, RegisterPage.class);
                startActivity(intent);
            }
        });

    }
}
