package com.example.senderside.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.senderside.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterPage extends AppCompatActivity {
Button button;
EditText userEdit,passEdit,emailEdit,mobileEdit,repassEdit;
private FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        button = findViewById(R.id.signupbtn);
        userEdit = findViewById(R.id.reguser);
        emailEdit = findViewById(R.id.regemail);
        passEdit = findViewById(R.id.regpass);
        mobileEdit = findViewById(R.id.regmobile);
        repassEdit = findViewById(R.id.regrepass);
        mauth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                String email = emailEdit.getText().toString();
                String mobile = mobileEdit.getText().toString();
                String pass = passEdit.getText().toString();
                String user = userEdit.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (email.equals("")) {
                    emailEdit.setError("Email can't be blank");
                    emailEdit.requestFocus();
                } else if (email.equals(emailPattern)) {
                    emailEdit.setError("Enter valid email");
                    emailEdit.requestFocus();
                } else if (pass.equals("")) {
                    passEdit.setError("Password can't be blank");
                    passEdit.requestFocus();
                } else if (pass.length() < 8) {
                    passEdit.setError("Please enter 8 character");
                    passEdit.requestFocus();
                } else if (mobile.equals("")) {
                    mobileEdit.setError("Mobile Number can't be blank");
                    mobileEdit.requestFocus();
                } else if (user.equals("")) {
                    userEdit.setError("Username can't be blank");
                    userEdit.requestFocus();
                }
                Intent intent = new Intent(RegisterPage.this,LoginPage.class);
                startActivity(intent);
                    /*mauth.createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Intent intent = new Intent(RegisterPage.this,LoginPage.class);
                                        startActivity(intent);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText( getApplicationContext(),"Authentication failed.",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });*/


            }
        });

    }
}
