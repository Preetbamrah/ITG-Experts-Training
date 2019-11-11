package com.example.common.bean;

public class TeacherBean {
    private  String teacher_name;
    private  String teacher_designation;

    public TeacherBean(String teacher_name, String teacher_designation) {
        this.teacher_name = teacher_name;
        this.teacher_designation = teacher_designation;
    }

    public TeacherBean() {
    }

    public String getTeacher_name() {

        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_designation() {
        return teacher_designation;
    }

    public void setTeacher_designation(String teacher_designation) {
        this.teacher_designation = teacher_designation;
    }
}
