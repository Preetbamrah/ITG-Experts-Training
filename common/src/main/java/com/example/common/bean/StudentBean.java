package com.example.common.bean;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentBean {
    private String student_id;
    private String student_firstname;
    private String student_fathername;
    private String student_mobilenumber;
    private String student_address;
    private String student_batch_to;
    private String student_batch_from;
    private String student_branch;
    private String student_course;
    private String student_contact;
    private String student_interested;
    private String student_reference;
    private  String student_email;
    private String student_rollno;
    private String student_sem;
    private String student_college;


    public StudentBean(String student_id, String student_firstname, String student_fathername, String student_mobilenumber, String student_address, String student_batch_to, String student_batch_from, String student_branch, String student_course, String student_contact, String student_interested, String student_reference, String student_email, String student_rollno, String student_sem, String student_college) {
        this.student_id = student_id;
        this.student_firstname = student_firstname;
        this.student_fathername = student_fathername;
        this.student_mobilenumber = student_mobilenumber;
        this.student_address = student_address;
        this.student_batch_to = student_batch_to;
        this.student_batch_from = student_batch_from;
        this.student_branch = student_branch;
        this.student_course = student_course;
        this.student_contact = student_contact;
        this.student_interested = student_interested;
        this.student_reference = student_reference;
        this.student_email = student_email;
        this.student_rollno = student_rollno;
        this.student_sem = student_sem;
        this.student_college = student_college;
    }

    public StudentBean() {

    }

    public String getStudent_batch_to() {
        return student_batch_to;
    }

    public void setStudent_batch_to(String student_batch_to) {
        this.student_batch_to = student_batch_to;
    }

    public String getStudent_batch_from() {
        return student_batch_from;
    }

    public void setStudent_batch_from(String student_batch_from) {
        this.student_batch_from = student_batch_from;
    }

    public String getStudent_branch() {
        return student_branch;
    }

    public void setStudent_branch(String student_branch) {
        this.student_branch = student_branch;
    }

    public String getStudent_course() {
        return student_course;
    }

    public void setStudent_course(String student_course) {
        this.student_course = student_course;
    }

    public String getStudent_contact() {
        return student_contact;
    }

    public void setStudent_contact(String student_contact) {
        this.student_contact = student_contact;
    }

    public String getStudent_interested() {
        return student_interested;
    }

    public void setStudent_interested(String student_interested) {
        this.student_interested = student_interested;
    }

    public String getStudent_reference() {
        return student_reference;
    }

    public void setStudent_reference(String student_reference) {
        this.student_reference = student_reference;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_rollno() {
        return student_rollno;
    }

    public void setStudent_rollno(String student_rollno) {
        this.student_rollno = student_rollno;
    }

    public String getStudent_sem() {
        return student_sem;
    }

    public void setStudent_sem(String student_sem) {
        this.student_sem = student_sem;
    }

    public String getStudent_college() {
        return student_college;
    }

    public void setStudent_college(String student_college) {
        this.student_college = student_college;
    }

    public  String getStudent_id() {
        return student_id;
    }
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    public String getStudent_firstname() {
        return student_firstname;
    }
    public void setStudent_firstname(String student_firstname) {
        this.student_firstname = student_firstname;
    }
    public String getStudent_fathername() {
        return student_fathername;
    }
    public void setStudent_fathername(String student_fathername) {
        this.student_fathername = student_fathername;
    }
    public String getStudent_mobilenumber() {
        return student_mobilenumber;
    }
    public void setStudent_mobilenumber(String student_mobilenumber) {
        this.student_mobilenumber = student_mobilenumber;
    }
    public String getStudent_address() {
        return student_address;
    }
    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }




}
