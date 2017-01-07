package com.example.foray.testapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "students.db";
    public static final String TABLE_STUDENTS = "students";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "_name";
    public static final String COLUMN_DEGREE = "_degree";
    public static final String COLUMN_ADDRESS= "_address";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    //CREATE QUERY FOR DB TABLE
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE" + TABLE_STUDENTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_NAME + " TEXT " +
                COLUMN_DEGREE + " TEXT " +
                COLUMN_ADDRESS + " CHAR(100) " +
                ");";
        sqLiteDatabase.execSQL(query);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_STUDENTS );
        onCreate(sqLiteDatabase);

    }



    // Add a new row into the DB
    public void addStudents(Students students){
        ContentValues v = new ContentValues();
        v.put(COLUMN_NAME,students.get_sname());
        v.put(COLUMN_DEGREE,students.get_sdegree());
        v.put(COLUMN_ADDRESS,students.get_saddress());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert(TABLE_STUDENTS,null,v);
        sqLiteDatabase.close();
    }





    // Delete the student details from the DB
    public void deleteStudents(String sname){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM" + TABLE_STUDENTS + "WHERE" + COLUMN_NAME + "=\"" + sname + "\";" );
    }



    // print the DB as a string
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_STUDENTS + " WHERE 1";



        //Cursor point to a location in your results
        Cursor c = sqLiteDatabase.rawQuery(query,null);



        //move to the first row in ur resluts
        c.moveToFirst();

        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("sname"))!= null){
                dbString += c.getString(c.getColumnIndex("sname"));
                dbString += "\n";
            }
        }
        sqLiteDatabase.close();
        return dbString;

    }
}
