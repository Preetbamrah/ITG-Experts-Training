package com.example.common.bean;

public class ViewBean {

    private  String userName;
    private String userEmail;
    private String userMobile;

    public void ViewBean(String name, String email, String mobile)
    {
        this.userEmail = name;
        this.userEmail = email;
        this.userMobile = mobile;

    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }




}
