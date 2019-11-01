package com.example.itgexperttraining.bean;

import android.widget.EditText;

public class UserBean {

    private String user_mo_no;
    private int user_id;
    private  String user_name;
    private String user_email;
    private String user_password;



    private String user_repass;

    public UserBean(String userId, EditText editEmail, EditText editPass, EditText editMobile, EditText editUser, EditText editRePass)
    {

    }
    public UserBean(int user_id,String user_email,String user_password,String user_name,String user_repass,String user_mo_no)
    {
            this.user_id = user_id;
            this.user_email = user_email;
            this.user_mo_no = user_mo_no;
            this.user_password = user_password;
            this.user_name = user_name;
            this.user_repass = user_repass;

    }


    public String getUser_mo_no() {
        return user_mo_no;
    }

    public void setUser_mo_no(String user_mo_no) {
        this.user_mo_no = user_mo_no;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_repass() {
        return user_repass;
    }

    public void setUser_repass(String user_repass) {
        this.user_repass = user_repass;
    }

}
