package com.example.common.bean;

import java.io.Serializable;

public class FacultyBean implements Serializable {
    private String userName;
    private String userId;
    private String userMobile;
    private String userPass;
    private String userEmail;

    public FacultyBean(String userId,String userName,String userMobile, String userPass, String userEmail)
    {
            this.setUserId(userId);
            this.setUserEmail(userEmail);
            this.setUserMobile(userMobile);
            this.setUserName(userName);
            this.setUserPass(userPass);
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
       return;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        return;
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




}
