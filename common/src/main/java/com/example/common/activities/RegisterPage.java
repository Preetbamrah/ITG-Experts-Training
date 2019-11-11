package com.example.common.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.common.R;
import com.example.common.bean.FirebaseApplication;
import com.example.common.bean.UserBean;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterPage extends AppCompatActivity {
EditText editText1,editText2,editText3,editText4,editText5;
    private static final String TAG = RegisterPage.class.getSimpleName();

    private EditText emailInput;

    private EditText passwordInput;

    private TextView signUpText;

    private TextView loginError;
    ProgressBar progressBar;

    private DatabaseReference mDatabaseReference;
    private FirebaseAuth mAuth;
    FirebaseUser user;

    Button button;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        editText1 = findViewById(R.id.reguser);
        editText2 = findViewById(R.id.regemail);
        editText3 = findViewById(R.id.regpass);
        button = findViewById(R.id.signupbtn);
        editText4 =  findViewById(R.id.mobile_edit);
        progressBar = (ProgressBar)findViewById(R.id.progress);
        editText5 = findViewById(R.id.repassreg);
        mAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = editText2.getText().toString();
                final String mobile = editText4.getText().toString();
                final String pass = editText3.getText().toString();
                final String user = editText1.getText().toString();
                String contactPattern = "(0/91)?[6-9][0-9]{9}";
                final String repass = editText5.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (email.equals("")) {
                    editText2.setError("Email can't be blank");
                    editText2.requestFocus();
                } else if (email.equals(emailPattern)) {
                    editText2.setError("Enter valid email");
                    editText2.requestFocus();
                } else if (pass.equals("")) {
                    editText3.setError("Password can't be blank");
                    editText3.requestFocus();
                } else if (pass.length() < 8) {
                    editText3.setError("Please enter 8 character");
                    editText3.requestFocus();
                } else if (mobile.equals("")) {
                    editText4.setError("Mobile Number can't be blank");
                    editText4.requestFocus();
                } else if (user.equals("")) {
                    editText1.setError("Username can't be blank");
                    editText1.requestFocus();
                }else  if (!mobile.matches(contactPattern))
                {
                    editText4.setError("Enter Valid Contact");
                    editText4.requestFocus();
                }
                else if (!repass.equals(pass))
                {
                    editText5.setError("Doesnot password match");
                    editText5.requestFocus();
                }
                else {
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.createUserWithEmailAndPassword(email,pass)
                           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful())
                                    {
                                        progressBar.setVisibility(View.GONE);
                                        UserBean userBean = new UserBean(user,
                                                email,
                                                mobile,
                                                pass);
                                        FirebaseDatabase.getInstance().getReference("User")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(userBean).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Intent intent = new Intent(RegisterPage.this,LoginPage.class);
                                                startActivity(intent);
                                                Toast.makeText(RegisterPage.this,"Registration Successful",Toast.LENGTH_LONG).show();

                                            }
                                        });
                                    }
                                    else {
                                        Toast.makeText(RegisterPage.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();


        if (mAuth.getCurrentUser()!= null)
        {

        }
    }
}
