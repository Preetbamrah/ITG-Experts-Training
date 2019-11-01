package com.example.itgexperttraining.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itgexperttraining.R;
import com.example.itgexperttraining.bean.UserBean;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterPage extends AppCompatActivity {
EditText editUser,editEmail,editPass,editMobile, editRePass;
Button button;
TextInputLayout textInputLayout;
TextView textView;
private FirebaseAuth mAuth;
DatabaseReference databaseReference;


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
        textInputLayout = findViewById(R.id.text__input_password);
        databaseReference= FirebaseDatabase.getInstance().getReference("Fculty");
       // textView = findViewById(R.id.text_login);
        mAuth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String user = editUser.getText().toString();
                final String email = editEmail.getText().toString().trim();
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
                if (!TextUtils.isEmpty(user)) {
                    String userId = databaseReference.push().getKey();
                    UserBean userBean = new UserBean(userId, editEmail, editPass, editMobile, editUser, editRePass);
                    databaseReference.child(userId).setValue(userBean);
//                Intent intent = new Intent(RegisterPage.this, LoginPage.class);
//                startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"set your name",Toast.LENGTH_LONG).show();
                }
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
