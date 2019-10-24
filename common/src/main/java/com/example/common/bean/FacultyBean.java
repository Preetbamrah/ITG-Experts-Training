package com.example.common.bean;

import java.io.Serializable;

public class FacultyBean implements Serializable {
    private int userId;
    private String userName;
    private String userMobile;
    private String userPass;
    private String userRePass;
    private String userEmail;

    /*public FacultyBean(int userId,String userName,String userMobile, String userPass, String userEmail,String userRePass)
    {
        this.userId = userId;
        this.userName = userName;
        this.userMobile = userMobile;
        this.userPass = userPass;
        this.userEmail = userEmail;
        this.userRePass = userRePass;
    }*/
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
       return;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
        return;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
        return;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return;
    }

    public String getUserRePass() {
        return userRePass;
    }

    public void setUserRePass(String userRePass) {
        this.userRePass = userRePass;
        return;
    }



}
