package com.example.common.bean;

public class UserBean {
   public String user_name;
   public String user_email;
   protected String user_mobile;

   public UserBean()
   {

   }


    public UserBean(String user_name, String user_email, String user_mobile) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_mobile = user_mobile;
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

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }
}
