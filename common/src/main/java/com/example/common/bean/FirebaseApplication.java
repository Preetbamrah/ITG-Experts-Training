package com.example.common.bean;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.common.activities.Dashboard;
import com.example.common.activities.LoginPage;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseApplication extends Application {

    private static final String TAG = FirebaseApplication.class.getSimpleName();

    public FirebaseAuth firebaseAuth;

    public FirebaseAuth.AuthStateListener mAuthListener;

    public FirebaseAuth getFirebaseAuth(){
        return firebaseAuth = FirebaseAuth.getInstance();
    }

    public String getFirebaseUserAuthenticateId() {
        String userId = null;
        if(firebaseAuth.getCurrentUser() != null){
            userId = firebaseAuth.getCurrentUser().getUid();
        }
        return userId;
    }

    public void checkUserLogin(final Context context){
        if(firebaseAuth.getCurrentUser() != null){
            Intent profileIntent = new Intent(context, Dashboard.class);
            context.startActivity(profileIntent);
        }
    }

    public void isUserCurrentlyLogin(final Context context){
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(null != user){
                    Intent profileIntent = new Intent(context, LoginPage.class);
                    context.startActivity(profileIntent);
                }else{
                    Intent loginIntent = new Intent(context, Dashboard.class);
                    context.startActivity(loginIntent);
                }
            }
        };
    }

    public void createNewUser(final Context context,String username ,String email,String mobilenumber, String password, String repassword){
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Failed to login. Invalid user",Toast.LENGTH_LONG);
                        }
                        else {
                            Intent intent = new Intent(context,LoginPage.class);
                            startActivity(intent);
                        }
                    }
                });
    }

    public void loginAUser(final Context context, String email, String password){
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity)context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail", task.getException());
                            Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(getApplicationContext(),"User has been Login",Toast.LENGTH_LONG).show();
                            Intent profileIntent = new Intent(context, Dashboard.class);
                            context.startActivity(profileIntent);
                        }
                    }
                });
    }

}