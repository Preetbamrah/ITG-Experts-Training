package com.example.common.context;

import android.app.Application;

import com.example.common.bean.FacultyBean;
import com.example.common.bean.StudentBean;

import java.util.ArrayList;

public class ApplicationContext extends Application {
	private FacultyBean facultyBean;
	private ArrayList<StudentBean> studentBeanList;
	
	public FacultyBean getFacultyBean() {
		return facultyBean;
	}
	public void setFacultyBean(FacultyBean facultyBean) {
		this.facultyBean = facultyBean;
	}
	public ArrayList<StudentBean> getStudentBeanList() {
		return studentBeanList;
	}
	public void setStudentBeanList(ArrayList<StudentBean> studentBeanList) {
		this.studentBeanList = studentBeanList;
	}
	
	

}
