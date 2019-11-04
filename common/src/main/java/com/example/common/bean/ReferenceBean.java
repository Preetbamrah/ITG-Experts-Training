package com.example.common.bean;

import java.io.Serializable;

public class ReferenceBean implements Serializable {
    private  int reference_id;
    private String student_teacher;
    private  String teacher_designation;
    private String student_friend;
    private String friend_cousre;

    public int getReference_id() {
        return reference_id;
    }

    public void setReference_id(int reference_id) {
        this.reference_id = reference_id;
    }

    public String getStudent_teacher() {
        return student_teacher;
    }

    public void setStudent_teacher(String student_teacher) {
        this.student_teacher = student_teacher;
    }

    public String getTeacher_designation() {
        return teacher_designation;
    }

    public void setTeacher_designation(String teacher_designation) {
        this.teacher_designation = teacher_designation;
    }

    public String getStudent_friend() {
        return student_friend;
    }

    public void setStudent_friend(String student_friend) {
        this.student_friend = student_friend;
    }

    public String getFriend_cousre() {
        return friend_cousre;
    }

    public void setFriend_cousre(String friend_cousre) {
        this.friend_cousre = friend_cousre;
    }
}
