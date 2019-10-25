package com.example.common.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.common.bean.FacultyBean;
import com.example.common.bean.StudentBean;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper {

    private static final  String DATABASE_NAME = "ITG";
    private static  final int DATABASE_VERSION = 3;

    private static final String FACULTY_INFO_TABLE = "faculty_table";
    private static final String STUDENT_INFO_TABLE = "student_table";


    // Contacts Table Columns names
    private static final String KEY_FACULTY_ID = "faculty_id";
    private static final String KEY_FACULTY_FIRSTNAME = "faculty_firstname";
    private static final String KEY_FACULTY_LASTNAME = "faculty_Lastname";
    private static final String KEY_FACULTY_MO_NO = "faculty_mobilenumber";
    private static final String KEY_FACULTY_ADDRESS = "faculty_address";
    private static final String KEY_FACULTY_USERNAME = "faculty_username";
    private static final String KEY_FACULTY_PASSWORD = "faculty_password";

    private static final String KEY_STUDENT_ID = "student_id";
    private static final String KEY_STUDENT_FIRSTNAME = "student_firstname";
    private static final String KEY_STUDENT_LASTNAME = "student_fathername";
    private static final String KEY_STUDENT_MO_NO = "student_mobilenumber";
    private static final String KEY_STUDENT_ADDRESS = "student_address";
    private static final String KEY_STUDENT_BATCH_TO = "student_batch_to";
    private static final String KEY_STUDENT_BATCH_FROM = "student_batch_from";
    private static final String KEY_STUDENT_OTHER_CONTACT = "student_contact";
    private static final String KEY_STUDENT_COURSE ="student_course";
    private static final String KEY_STUDENT_BRANCH = "student_branch";
    private static final String KEY_STUDENT_COLLEGE = "student_college";
    private static final String KEY_STUDENT_INTERESTED = "student_interested";
    private static final String KEY_STUDENT_EMAIL = "student_email";
    private static final String KEY_STUDENT_ROLLNO = "student_rollno";
    private static final String KEY_STUDENT_SEM = "student_sem";
    private static final String KEY_STUDENT_REFERENCE = "student_reference";

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override

    public void onCreate(SQLiteDatabase db) {
        //Create Table and insert data in table
        String queryFaculty="CREATE TABLE "+ FACULTY_INFO_TABLE +" (" +
                KEY_FACULTY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_FACULTY_FIRSTNAME + " TEXT, " +
                KEY_FACULTY_LASTNAME + " TEXT, " +
                KEY_FACULTY_MO_NO + " TEXT, " +
                KEY_FACULTY_ADDRESS + " TEXT," +
                KEY_FACULTY_USERNAME + " TEXT," +
                KEY_FACULTY_PASSWORD + " TEXT " + ")";
        Log.d("queryFaculty",queryFaculty);


        String queryStudent="CREATE TABLE "+ STUDENT_INFO_TABLE +" (" +
                KEY_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_STUDENT_FIRSTNAME + " TEXT, " +
                KEY_STUDENT_LASTNAME + " TEXT, " +
                KEY_STUDENT_MO_NO + " TEXT, " +
                KEY_STUDENT_ADDRESS + " TEXT," +
                KEY_STUDENT_BATCH_FROM + " TEXT," +
                KEY_STUDENT_BATCH_TO+ " TEXT," +
                KEY_STUDENT_BRANCH + " TEXT," +
                KEY_STUDENT_COLLEGE+ " TEXT," +
                KEY_STUDENT_COURSE + " TEXT," +
                KEY_STUDENT_OTHER_CONTACT + " TEXT," +
                KEY_STUDENT_REFERENCE + " TEXT," +
                KEY_STUDENT_ROLLNO + " TEXT," +
                KEY_STUDENT_INTERESTED + " TEXT," +
                KEY_STUDENT_EMAIL + " TEXT," +
                KEY_STUDENT_SEM + " TEXT " + ")";
        Log.d("queryStudent",queryStudent );

        try
        {
            db.execSQL(queryFaculty);
            db.execSQL(queryStudent);
        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        String queryFaculty="CREATE TABLE "+ FACULTY_INFO_TABLE +
                " (" +
                KEY_FACULTY_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_FACULTY_FIRSTNAME + " TEXT, " +
                KEY_FACULTY_LASTNAME + " TEXT, " +
                KEY_FACULTY_MO_NO + " TEXT, " +
                KEY_FACULTY_ADDRESS + " TEXT," +
                KEY_FACULTY_USERNAME + " TEXT," +
                KEY_FACULTY_PASSWORD + " TEXT " + ")";
        Log.d("queryFaculty",queryFaculty);


        String queryStudent="CREATE TABLE "+ STUDENT_INFO_TABLE +" (" +
                KEY_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_STUDENT_FIRSTNAME + " TEXT, " +
                KEY_STUDENT_LASTNAME + " TEXT, " +
                KEY_STUDENT_MO_NO + " TEXT, " +
                KEY_STUDENT_ADDRESS + " TEXT," +
                KEY_STUDENT_BATCH_FROM + " TEXT," +
                KEY_STUDENT_BATCH_TO+ " TEXT," +
                KEY_STUDENT_BRANCH + " TEXT," +
                KEY_STUDENT_COLLEGE+ " TEXT," +
                KEY_STUDENT_COURSE + " TEXT," +
                KEY_STUDENT_OTHER_CONTACT + " TEXT," +
                KEY_STUDENT_REFERENCE + " TEXT," +
                KEY_STUDENT_ROLLNO + " TEXT," +
                KEY_STUDENT_INTERESTED + " TEXT," +
                KEY_STUDENT_EMAIL + " TEXT," +
                KEY_STUDENT_SEM + " TEXT " + ")";
        Log.d("queryStudent",queryStudent );
        try
        {
            db.execSQL(queryFaculty);
            db.execSQL(queryStudent);
        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }
    }

    //facult crud
    public void addFaculty(FacultyBean facultyBean) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "INSERT INTO faculty_table (faculty_firstname,faculty_Lastname,faculty_mobilenumber,faculty_address,faculty_username,faculty_password) values ('"+
                facultyBean.getFaculty_firstname()+ "', '"+
                facultyBean.getFaculty_lastname()+"', '"+
                facultyBean.getFaculty_mobilenumber()+"', '"+
                facultyBean.getFaculty_address()+"', '"+
                facultyBean.getFaculty_username()+"', '"+
                facultyBean.getFaculty_password()+"')";
        Log.d("query", query);
        db.execSQL(query);
        db.close();
    }

    public FacultyBean validateFaculty(String userName,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM faculty_table where faculty_username='"+userName+"' and faculty_password='"+password+"'";
        //rawQuery is a method that uses the select the particlar data in the database
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {

            FacultyBean facultyBean = new FacultyBean();
            facultyBean.setFaculty_id(Integer.parseInt(cursor.getString(0)));
            facultyBean.setFaculty_firstname(cursor.getString(1));
            facultyBean.setFaculty_lastname(cursor.getString(2));
            facultyBean.setFaculty_mobilenumber(cursor.getString(3));
            facultyBean.setFaculty_address(cursor.getString(4));
            facultyBean.setFaculty_username(cursor.getString(5));
            facultyBean.setFaculty_password(cursor.getString(6));
            return facultyBean;
        }
        return null;
    }

    public ArrayList<FacultyBean> getAllFaculty()
    {
        Log.d("in get all","in get all" );
        ArrayList<FacultyBean> list = new ArrayList<FacultyBean>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM faculty_table";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst())
        {
            do{
                FacultyBean facultyBean = new FacultyBean();
                facultyBean.setFaculty_id(Integer.parseInt(cursor.getString(0)));
                facultyBean.setFaculty_firstname(cursor.getString(1));
                facultyBean.setFaculty_lastname(cursor.getString(2));
                facultyBean.setFaculty_mobilenumber(cursor.getString(3));
                facultyBean.setFaculty_address(cursor.getString(4));
                facultyBean.setFaculty_username(cursor.getString(5));
                facultyBean.setFaculty_password(cursor.getString(6));
                list.add(facultyBean);

            }while(cursor.moveToNext());
        }
        return list;
    }

    public void deleteFaculty(int facultyId) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE FROM faculty_table WHERE faculty_id="+facultyId ;

        Log.d("query", query);
        db.execSQL(query);
        db.close();
    }

    //student crud
    public void addStudent(StudentBean studentBean) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "INSERT INTO student_table (student_firstname,student_fathername,student_mobilenumber,student_address,student_batch_to,student_batch_from,student_branch,student_course,student_contact,student_interested,student_reference,student_email,student_rollno,student_sem,student_college) values ('"+
                studentBean.getStudent_firstname()+"', '"+
                studentBean.getStudent_fathername()+"','"+
                studentBean.getStudent_mobilenumber()+"', '"+
                studentBean.getStudent_address()+"', '"+
                studentBean.getStudent_batch_from()+"', '"+
                studentBean.getStudent_batch_to()+"', '"+
                studentBean.getStudent_branch()+"', '"+
                studentBean.getStudent_college()+"', '"+
                studentBean.getStudent_contact()+"', '"+
                studentBean.getStudent_course()+"', '"+
                studentBean.getStudent_reference()+"', '"+
                studentBean.getStudent_rollno()+"', '"+
                studentBean.getStudent_interested()+"', '"+
                studentBean.getStudent_email()+"', '"+
                studentBean.getStudent_sem()+"')";
        Log.d("query", query);
        db.execSQL(query);
        db.close();
    }

    public ArrayList<StudentBean> getAllStudent()
    {
        ArrayList<StudentBean> list = new ArrayList<StudentBean>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM student_table";
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            do{
                StudentBean studentBean = new StudentBean();
                studentBean.setStudent_id(Integer.parseInt(cursor.getString(0)));
                studentBean.setStudent_firstname(cursor.getString(1));
                studentBean.setStudent_fathername(cursor.getString(2));
                studentBean.setStudent_mobilenumber(cursor.getString(3));
                studentBean.setStudent_address(cursor.getString(4));
                studentBean.setStudent_batch_from(cursor.getString(5));
                studentBean.setStudent_batch_to(cursor.getString(6));
                studentBean.setStudent_branch(cursor.getString(7));
                studentBean.setStudent_college(cursor.getString(8));
                studentBean.setStudent_contact(cursor.getString(9));
                studentBean.setStudent_course(cursor.getString(10));
                studentBean.setStudent_sem(cursor.getString(11));
                studentBean.setStudent_email(cursor.getString(12));
                studentBean.setStudent_interested(cursor.getString(13));
                studentBean.setStudent_reference(cursor.getString(14));
                studentBean.setStudent_rollno(cursor.getString(15));

                list.add(studentBean);
            }while(cursor.moveToNext());
        }
        return list;
    }

    public ArrayList<StudentBean> getAllStudentByBranchYear(String branch,String year)
    {
        ArrayList<StudentBean> list = new ArrayList<StudentBean>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM student_table where student_department='"+branch+"' and student_class='"+year+"'";
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            do{
                StudentBean studentBean = new StudentBean();
                studentBean.setStudent_id(Integer.parseInt(cursor.getString(0)));
                studentBean.setStudent_firstname(cursor.getString(1));
                studentBean.setStudent_fathername(cursor.getString(2));
                studentBean.setStudent_mobilenumber(cursor.getString(3));
                studentBean.setStudent_address(cursor.getString(4));
                studentBean.setStudent_batch_from(cursor.getString(5));
                studentBean.setStudent_batch_to(cursor.getString(6));
                studentBean.setStudent_branch(cursor.getString(7));
                studentBean.setStudent_college(cursor.getString(8));
                studentBean.setStudent_contact(cursor.getString(9));
                studentBean.setStudent_course(cursor.getString(10));
                studentBean.setStudent_sem(cursor.getString(11));
                studentBean.setStudent_email(cursor.getString(12));
                studentBean.setStudent_interested(cursor.getString(13));
                studentBean.setStudent_reference(cursor.getString(14));
                studentBean.setStudent_rollno(cursor.getString(15));
                list.add(studentBean);
            }while(cursor.moveToNext());
        }
        return list;
    }

    public StudentBean getStudentById(int studentId)
    {
        StudentBean studentBean = new StudentBean();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM student_table where student_id="+studentId;
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            do{
                studentBean.setStudent_id(Integer.parseInt(cursor.getString(0)));
                studentBean.setStudent_firstname(cursor.getString(1));
                studentBean.setStudent_fathername(cursor.getString(2));
                studentBean.setStudent_mobilenumber(cursor.getString(3));
                studentBean.setStudent_address(cursor.getString(4));
                studentBean.setStudent_batch_from(cursor.getString(5));
                studentBean.setStudent_batch_to(cursor.getString(6));
                studentBean.setStudent_branch(cursor.getString(7));
                studentBean.setStudent_college(cursor.getString(8));
                studentBean.setStudent_contact(cursor.getString(9));
                studentBean.setStudent_course(cursor.getString(10));
                studentBean.setStudent_sem(cursor.getString(11));
                studentBean.setStudent_email(cursor.getString(12));
                studentBean.setStudent_interested(cursor.getString(13));
                studentBean.setStudent_reference(cursor.getString(14));
                studentBean.setStudent_rollno(cursor.getString(15));

            }while(cursor.moveToNext());
        }
        return studentBean;
    }

    public void deleteStudent(int studentId) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE FROM student_table WHERE student_id="+studentId ;

        Log.d("query", query);
        db.execSQL(query);
        db.close();
    }

}
