package com.example.senderside.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.senderside.Bean.FirebaseApplication;
import com.example.senderside.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity {
Button button;
TextView textView;
EditText emailEdit,passEdit;
private int textSize = 0;
private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        button = findViewById(R.id.loginbtn);
        textView = findViewById(R.id.logreg);
        emailEdit = findViewById(R.id.logemail);
        passEdit = findViewById(R.id.logpassword);
        mAuth = ((FirebaseApplication)getApplication()).getFirebaseAuth();
        ((FirebaseApplication)getApplication()).checkUserLogin(LoginPage.this);

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                String email = emailEdit.getText().toString();
                String pass = passEdit.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(pass.length()< 8)
                {
                    passEdit.setError("Password length must have atleast 8 character");
                    passEdit.requestFocus();
                }
                else if (email.equals(emailPattern))
                {
                    emailEdit.setError("Please enter correct Email");
                    emailEdit.requestFocus();
                }
                else if (pass.equals(""))
                {
                    passEdit.setError("Password can't be blank");
                    passEdit.requestFocus();
                }
                else if(email.equals(""))
                {
                    emailEdit.setError("Email can't be blank");
                    emailEdit.requestFocus();
                }
                else  {
                    ((FirebaseApplication) getApplication()).loginAUser(LoginPage.this, email, pass);

                }

            }
        });
        textView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent = new Intent(LoginPage.this, RegisterPage.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        //mAuth.addAuthStateListener(((FirebaseApplication)getApplication()).mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (((FirebaseApplication)getApplication()).mAuthListener != null) {
            //mAuth.removeAuthStateListener(((FirebaseApplication)getApplication()).mAuthListener);
        }
    }
}
