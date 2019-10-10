package com.example.itgexperttraining.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.itgexperttraining.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterPage extends AppCompatActivity {
EditText editUser,editEmail,editPass,editMobile, editRePass;
Button button;
TextView textView;
private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        editUser = findViewById(R.id.reguser);
        editEmail = findViewById(R.id.regemail);
        editPass = findViewById(R.id.regpass);
        editRePass = findViewById(R.id.regrepass);
        editMobile = findViewById(R.id.regmobile);
        button = findViewById(R.id.signupbtn);
       // textView = findViewById(R.id.text_login);
        mAuth = FirebaseAuth.getInstance();
        /*textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterPage.this, LoginPage.class);
                startActivity(intent);
            }
        });*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = editUser.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String pass = editPass.getText().toString().trim();
                String mobile = editMobile.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (TextUtils.isEmpty(user))
                {
                    editUser.setError("Enter Your Name");
                    editUser.requestFocus();
                } else if (TextUtils.isEmpty(email))
                {
                    editEmail.setError("Enter Your Email");
                    editEmail.requestFocus();
                }
                 if (email.equals(emailPattern))
                {
                    editEmail.setError("Enter valid email address");
                    editEmail.requestFocus();
                }
                if (TextUtils.isEmpty(pass))
                {
                    editPass.setError("Enter your password");
                    editPass.requestFocus();
                }
                if (pass.length()<6)
                {
                    editPass.setError("Enter valid password");
                    editPass.requestFocus();
                }
                 if (TextUtils.isEmpty(mobile))
                {
                    editMobile.setError("Enter your mobile number");
                    editMobile.requestFocus();
                }
                 if (mobile.length()!= 10&& mobile.length()> 10)
                {
                    editMobile.setError("Enter valid mobile number");
                    editMobile.requestFocus();
                }
                Intent intent = new Intent(RegisterPage.this, LoginPage.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser  currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    private void updateUI(FirebaseUser user)
    {
        //hideProgressDialog();
       /* if (user != null) {
            mStatusTextView.setText(getString(R.string.emailpassword_status_fmt,
                    user.getEmail(), user.isEmailVerified()));
            mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));

            findViewById(R.id.emailPasswordButtons).setVisibility(View.GONE);
            findViewById(R.id.emailPasswordFields).setVisibility(View.GONE);
            findViewById(R.id.signedInButtons).setVisibility(View.VISIBLE);

            findViewById(R.id.verifyEmailButton).setEnabled(!user.isEmailVerified());
        } else {
            mStatusTextView.setText(R.string.signed_out);
            mDetailTextView.setText(null);

            findViewById(R.id.emailPasswordButtons).setVisibility(View.VISIBLE);
            findViewById(R.id.emailPasswordFields).setVisibility(View.VISIBLE);
            findViewById(R.id.signedInButtons).setVisibility(View.GONE);
        }*/
    }
}
