package com.example.common.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import javax.sql.StatementEvent;

public class MyDbHelper extends SQLiteOpenHelper {

    private static final  String DATABASE_NAME = "ITG";
    private static  final int DATABASE_VERSION = 1;

    //Create table
    private static  final String USER_INFO_TABLE = "user_table";

    private static final String USER_NAME = "user_name";
    private static final String USER_EMAIL = "user_email";
    private static final String USER_ID = "user_id";
    private static final String USER_MO_NO = "user_mo_no";
    private static final String USER_STATUS = "user_status";

    public  MyDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db)
    {
        String queryTable = "CREATE TABLE "+ USER_INFO_TABLE+"("+
        USER_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                USER_NAME
                +"TEXT,"+USER_EMAIL+"TEXT,"+USER_MO_NO+"TEXT,"+USER_STATUS+"TEXT,"+")";
        Log.d("queryUser",queryTable);
        try
        {
            db.execSQL(queryTable);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
        }

    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion)
    {
        String queryTable = "CREATE TABLE "+ USER_INFO_TABLE+"("+
                USER_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                USER_NAME
                +"TEXT,"+USER_EMAIL+"TEXT,"+USER_MO_NO+"TEXT,"+USER_STATUS+"TEXT,"+")";
        Log.d("queryUser",queryTable);
        try
        {
            db.execSQL(queryTable);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
        }

    }
}
