package com.example.itgexperttraining.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.itgexperttraining.bean.UserBean;

import java.util.ArrayList;

public class DBAdapter extends SQLiteOpenHelper {

    private static  final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ITG";

    public  static final String USER_INFO_TABLE = "user_table";

    public static final String USER_NAME = "user_name";
    private  static final String USER_ID = "user_id";
    private  static  final String USER_MO_NO = "user_mo_no";
    private  static  final String USER_PASS = "user_pass";
    private  static final String  USER_EMAIL = "user_email";


    public DBAdapter(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryUser = "CREATE TABLE "+USER_INFO_TABLE+"("+
                USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                USER_NAME +"TEXT,"+
                USER_EMAIL+"TEXT,"+
                USER_MO_NO+"TEXT,"+
                USER_PASS+" TEXT" +")";
        Log.d("queryUser",queryUser);
        try
        {
            db.execSQL(queryUser);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String queryUser = "CREATE TABLE "+USER_INFO_TABLE+"("+
                USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                USER_NAME +"TEXT,"+
                USER_EMAIL+"TEXT,"+
                USER_MO_NO+"TEXT,"+
                USER_PASS+" TEXT" +")";
        Log.d("queryUser",queryUser);
        try
        {
            db.execSQL(queryUser);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
        }


    }

    public  void  addUser(UserBean userBean)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "INSERT INTO user_table (user_name,user_email,user_mo_no,user_pass) values ('"+
                        userBean.getUser_name()+"','"+
                        userBean.getUser_email()+"','"+
                        userBean.getUser_mo_no()+"','"+
                        userBean.getUser_password()+")";
        Log.d("query",query);
        db.execSQL(query);
        db.close();
    }

    public UserBean validateUser(String userName, String password )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM user_table where user_name='"+userName+"' and user_password='"+password+"'";
        //rawQuery is a method that uses the select the particlar data in the database
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {

            UserBean userBean = new UserBean();
            userBean.setUser_id(Integer.parseInt(cursor.getString(0)));
            userBean.setUser_name(cursor.getString(1));
            userBean.setUser_email(cursor.getString(2));
            userBean.setUser_mo_no(cursor.getString(3));
            userBean.setUser_password(cursor.getString(4));
            return userBean;
        }
        return null;

    }

    public ArrayList<UserBean> getAllFaculty()
    {
        Log.d("in get all","in get all" );
        ArrayList<UserBean> list = new ArrayList<UserBean>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM faculty_table";
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            do{
                UserBean userBean = new UserBean();
                userBean.setUser_id(Integer.parseInt(cursor.getString(0)));
                userBean.setUser_name(cursor.getString(1));
                userBean.setUser_email(cursor.getString(2));
                userBean.setUser_mo_no(cursor.getString(3));
                userBean.setUser_password(cursor.getString(4));
                list.add(userBean);

            }while(cursor.moveToNext());
        }
        return list;
    }
    public void deleteUser(int userId) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE FROM user_table WHERE user_id="+userId ;

        Log.d("query", query);
        db.execSQL(query);
        db.close();
    }

}
