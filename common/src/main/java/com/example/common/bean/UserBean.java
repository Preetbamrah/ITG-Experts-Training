package com.example.common.bean;

public class UserBean {
    public UserBean(String username, String userid,String useremail,String usermono, String userstatus){
        this.user_email = useremail;
        this.user_id = userid;
        this.user_mo_no= usermono;
        this.user_name = username;
        this.user_status = userstatus;
    }
    private String user_name;
    private String user_email;
    private String user_id;
    private String user_mo_no;
    private String user_status;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
        return;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
        return;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
        return;
    }

    public String getUser_mo_no() {
        return user_mo_no;
    }

    public void setUser_mo_no(String user_mo_no) {
        this.user_mo_no = user_mo_no;
        return;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
        return;
    }
}
