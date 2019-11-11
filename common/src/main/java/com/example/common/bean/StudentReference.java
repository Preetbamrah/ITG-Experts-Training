package com.example.common.bean;

public class StudentReference {
    private  String student_name;
    private String student_course;

    public StudentReference() {
    }

    public StudentReference(String student_name, String student_course) {

        this.student_name = student_name;
        this.student_course = student_course;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_course() {
        return student_course;
    }

    public void setStudent_course(String student_course) {
        this.student_course = student_course;
    }
}
