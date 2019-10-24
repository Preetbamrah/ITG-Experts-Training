package com.example.common.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.common.bean.FacultyBean;
import com.example.common.bean.StudentBean;

import java.util.ArrayList;

import javax.sql.StatementEvent;

public class MyDbHelper extends SQLiteOpenHelper {

    private static final  String DATABASE_NAME = "ITG";
    private static  final int DATABASE_VERSION = 1;

    //Create table
    private static  final String FACULTY_INFO_TABLE = "faculty_table";
    private static final String REGISTRATION_INFO_TABLE = "student_table";


    //faculty colums
    private static final String USER_NAME = "userName";
    private static final String USER_EMAIL = "userEmail";
    private static final String USER_ID = "userId";
    private static final String USER_MO_NO = "userMobile";
    private static final String USER_PASS = "userPass";
    private static final String USER_RE_PASS= "userRePass";

    //student registration form colmn
    private static final String STUDENT_ID = "studentId";
    private  static final String STUDENT_NAME = "studentName";
    private static final String STUDENT_FATHER_NAME = "studentFatherName";
    private static final String STUDENT_COLLEGE = "studentCollege";
    private static final String STUDENT_EMAIL = "studentEmail";
    private static final String STUDENT_CONTACT = "studentConatct";
    private static final String STUDENT_OTHER_CONTACT = "studentOtherContact";
    private static final String STUDENT_ADDRESS = "studentAddress";
    private static final String STUDENT_INTERESTED = "studentInterested";
    private static final String STUDENT_BRANCH = "studentBranch";
    private static final String STUDENT_COURSE = "studentCourse";
    private static final String STUDENT_ROLL_NO = "studentRollno";
    private static final String STUDENT_BATCH = "studentBatch";
    private static final String STUDENT_SEMESTER = "studentSem";
    private static final String STUDENT_REFERENCE = "studentReference";

    public  MyDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db)
    {
        String queryFacultyTable = "CREATE TABLE "+ FACULTY_INFO_TABLE+"("+
        USER_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                USER_NAME
                +"TEXT,"+USER_EMAIL+"TEXT,"+USER_MO_NO+"TEXT,"+USER_PASS+"TEXT,"+USER_RE_PASS+"TEXT" + ")";
        Log.d("queryFacultyTable",queryFacultyTable);

        String queryStudentTable = "CREATE TABLE "+REGISTRATION_INFO_TABLE+"("
                + STUDENT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                STUDENT_NAME+"TEXT,"
                +STUDENT_FATHER_NAME+"TEXT, "+
                STUDENT_ADDRESS+"TEXT," +
                STUDENT_BATCH+"TEXT,"+
                STUDENT_BRANCH+"TEXT, "+
                STUDENT_COLLEGE+"TEXT,"+
                STUDENT_CONTACT+"TEXT,"+
                STUDENT_COURSE+"TEXT,"+
                STUDENT_EMAIL+"TEXT,"+
                STUDENT_INTERESTED+"TEXT,"+
                STUDENT_OTHER_CONTACT+"TEXT,"+
                STUDENT_REFERENCE+"TEXT,"+
                STUDENT_ROLL_NO+"TEXT,"+
                STUDENT_SEMESTER+"TEXT"
                +")";
        Log.d("queryStudentTable",queryStudentTable);
        try
        {
            db.execSQL(queryFacultyTable);
            db.execSQL(queryStudentTable);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
        }


    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion)
    {
        String queryFacultyTable = "CREATE TABLE "+ FACULTY_INFO_TABLE+"("+
                USER_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                USER_NAME
                +"TEXT,"+USER_EMAIL+"TEXT,"+USER_MO_NO+"TEXT,"+USER_PASS+"TEXT,"+USER_RE_PASS+"TEXT" + ")";
        Log.d("queryFacultyTable",queryFacultyTable);
        String queryStudentTable = "CREATE TABLE "+REGISTRATION_INFO_TABLE+"("
                + STUDENT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                STUDENT_NAME+"TEXT,"
                +STUDENT_FATHER_NAME+"TEXT, "+
                STUDENT_ADDRESS+"TEXT," +
                STUDENT_BATCH+"TEXT,"+
                STUDENT_BRANCH+"TEXT, "+
                STUDENT_COLLEGE+"TEXT,"+
                STUDENT_CONTACT+"TEXT,"+
                STUDENT_COURSE+"TEXT,"+
                STUDENT_EMAIL+"TEXT,"+
                STUDENT_INTERESTED+"TEXT,"+
                STUDENT_OTHER_CONTACT+"TEXT,"+
                STUDENT_REFERENCE+"TEXT,"+
                STUDENT_ROLL_NO+"TEXT,"+
                STUDENT_SEMESTER+"TEXT"
                +")";
        Log.d("queryStudentTable",queryStudentTable);
        try
        {
            db.execSQL(queryFacultyTable);
            db.execSQL(queryStudentTable);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
        }

    }

    //Faculty CRUD
    public void addFaculty(FacultyBean facultyBean)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "INSERT INTO faculty_table(userName,userEmail,userMoNo,userPass,userRePass) values ('"+
                facultyBean.getUserName()+
                "', '"+
                facultyBean.getUserEmail()+"', '"+
                facultyBean.getUserMobile()+"', '"+
                facultyBean.getUserPass()+"', '"+
                facultyBean.getUserRePass()+"')";
        Log.d("query", query);
        database.execSQL(query);
        database.close();
    }

    public FacultyBean validateFaculty(String userName,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM faculty_table where userName ='"+userName+"' and userPass='"+password+"'";
        //rawQuery is a method that uses the select the particlar data in the database
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {

            FacultyBean facultyBean = new FacultyBean();
            facultyBean.setUserId(Integer.parseInt(cursor.getString(0)));
            facultyBean.setUserName(cursor.getString(1));
            facultyBean.setUserMobile(cursor.getString(2));
            facultyBean.setUserPass(cursor.getString(3));
            facultyBean.setUserEmail(cursor.getString(4));
            facultyBean.setUserRePass(cursor.getString(5));
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
                facultyBean.setUserId(Integer.parseInt(cursor.getString(0)));
                facultyBean.setUserName(cursor.getString(1));
                facultyBean.setUserMobile(cursor.getString(2));
                facultyBean.setUserPass(cursor.getString(3));
                facultyBean.setUserEmail(cursor.getString(4));
                facultyBean.setUserRePass(cursor.getString(5));
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

        String query = "INSERT INTO student_table (studentId, studentName, studentFatherName, studentAddress, studentEmail,\n" +
                "            studentContact, studentOtherContact, studentCollege, studentRollno, studentCourse,\n" +
                "             studentBranch, studentBatch, studentInterested, studentSem, studentReference) values ('"+
                studentBean.getStudentId()+"', '"+
                studentBean.getStudentName()+"','"+
                studentBean.getStudentFatherName()+"', '"+
                studentBean.getStudentAddress()+"', '"+
                studentBean.getStudentEmail()+"', '"+
                studentBean.getStudentContact()+"', '"+
                studentBean.getStudentOtherContact()+"', '"+
                studentBean.getStudentCollege()+"','"+
                studentBean.getStudentRollno()+"', '"+
                studentBean.getStudentCourse()+"', '"+
                studentBean.getStudentBranch()+"', '"+
                studentBean.getStudentBatch()+"', '"+
                studentBean.getStudentInterested()+"','"+
                studentBean.getStudentSem()+"', '"+
                studentBean.getStudentReference()+"')";
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
                studentBean.setStudentId(Integer.parseInt(cursor.getString(0)));
                studentBean.setStudentName(cursor.getString(1));
                studentBean.setStudentFatherName(cursor.getString(2));
                studentBean.setStudentAddress(cursor.getString(3));
                studentBean.setStudentEmail(cursor.getString(4));
                studentBean.setStudentContact(cursor.getString(5));
                studentBean.setStudentOtherContact(cursor.getString(6));
                studentBean.setStudentCollege(cursor.getString(7));
                studentBean.setStudentRollno(cursor.getString(8));
                studentBean.setStudentCourse(cursor.getString(9));
                studentBean.setStudentBranch(cursor.getString(10));
                studentBean.setStudentBatch(cursor.getString(11));
                studentBean.setStudentInterested(cursor.getString(12));
                studentBean.setStudentSem(cursor.getString(13));
                studentBean.setStudentReference(cursor.getString(14));
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
                studentBean.setStudentId(Integer.parseInt(cursor.getString(0)));
                studentBean.setStudentName(cursor.getString(1));
                studentBean.setStudentFatherName(cursor.getString(2));
                studentBean.setStudentAddress(cursor.getString(3));
                studentBean.setStudentEmail(cursor.getString(4));
                studentBean.setStudentContact(cursor.getString(5));
                studentBean.setStudentOtherContact(cursor.getString(6));
                studentBean.setStudentCollege(cursor.getString(7));
                studentBean.setStudentRollno(cursor.getString(8));
                studentBean.setStudentCourse(cursor.getString(9));
                studentBean.setStudentBranch(cursor.getString(10));
                studentBean.setStudentBatch(cursor.getString(11));
                studentBean.setStudentInterested(cursor.getString(12));
                studentBean.setStudentSem(cursor.getString(13));
                studentBean.setStudentReference(cursor.getString(14));
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

                studentBean.setStudentId(Integer.parseInt(cursor.getString(0)));
                studentBean.setStudentName(cursor.getString(1));
                studentBean.setStudentFatherName(cursor.getString(2));
                studentBean.setStudentAddress(cursor.getString(3));
                studentBean.setStudentEmail(cursor.getString(4));
                studentBean.setStudentContact(cursor.getString(5));
                studentBean.setStudentOtherContact(cursor.getString(6));
                studentBean.setStudentCollege(cursor.getString(7));
                studentBean.setStudentRollno(cursor.getString(8));
                studentBean.setStudentCourse(cursor.getString(9));
                studentBean.setStudentBranch(cursor.getString(10));
                studentBean.setStudentBatch(cursor.getString(11));
                studentBean.setStudentInterested(cursor.getString(12));
                studentBean.setStudentSem(cursor.getString(13));
                studentBean.setStudentReference(cursor.getString(14));

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
