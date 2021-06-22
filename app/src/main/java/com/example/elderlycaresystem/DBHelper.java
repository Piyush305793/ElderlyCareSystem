package com.example.elderlycaresystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "ElderCare.db";

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE customer(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, mobile TEXT, city TEXT, blood_group TEXT, weight TEXT, age TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("DROP TABLE if exists customer");
    }

    public boolean updateCustomer(String name, String mobile, String city, String blood_group, String weight, String age){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("mobile", mobile);
        contentValues.put("city", city);
        contentValues.put("blood_group", blood_group);
        contentValues.put("weight", weight);
        contentValues.put("age", age);
        long result = MyDB.update("customer", contentValues, "_id=?", new String[]{String.valueOf(1)});
        if(result == -1)
            return false;
        else
            return true;
    }

    public void insertCust(){
        String name = "Name", mobile = "Mobile Number", city = "City", blood = "Blood Group", weight = "Weight", age = "Age";
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("mobile", mobile);
        contentValues.put("city", city);
        contentValues.put("blood_group", blood);
        contentValues.put("weight", weight);
        contentValues.put("age", age);
        MyDB.insert("customer", null, contentValues);
    }
    }
