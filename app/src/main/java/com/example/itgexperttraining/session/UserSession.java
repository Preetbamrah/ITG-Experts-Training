package com.example.itgexperttraining.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class UserSession {
    private static UserSession instance;
    private SharedPreferences sp;
    private SharedPreferences.Editor spEditor;
    private static final String USER_ID ="user_id";
    private static final String LOGGED_IN ="logged_in";
    private  static  final String USER_NAME="user_name";
    private  static final  String USER_EMAIL="user_email";


    public static synchronized UserSession getInstance(Context context) {

        if (instance == null) {
            instance = new UserSession(context);
        }
        return instance;
    }

    public void setContext(Context context) {
        this.sp = PreferenceManager.getDefaultSharedPreferences(context);
    }

    private UserSession(Context context)
    {
        this.sp = PreferenceManager.getDefaultSharedPreferences(context);
    }


    public boolean setUserId(String id) {
        this.spEditor = this.sp.edit();
        this.spEditor.putString(USER_ID,id);
        this.spEditor.apply();
        return true;
    }

    public String getUserId()
    {
        return this.sp.getString(USER_ID, null);

    }

    public boolean setUserName(String username) {
        this.spEditor = this.sp.edit();
        this.spEditor.putString(USER_NAME,username);
        this.spEditor.apply();
        return true;
    }

    public String getUserName()
    {
        return this.sp.getString(USER_NAME, null);

    }
    public boolean setUserEmail(String email) {
        this.spEditor = this.sp.edit();
        this.spEditor.putString(USER_EMAIL,email);
        this.spEditor.apply();
        return true;
    }

    public String getUserEmail()
    {
        return this.sp.getString(USER_EMAIL, null);

    }

    public boolean isLoggedIn()
    {
        return this.sp.getBoolean(LOGGED_IN,false);
    }

    public  boolean setUserLoggedIn(boolean isLoggedIn)
    {
        this.spEditor=this.sp.edit();
        this.spEditor.putBoolean(LOGGED_IN,isLoggedIn);
        this.spEditor.apply();
        return true;
    }

}
