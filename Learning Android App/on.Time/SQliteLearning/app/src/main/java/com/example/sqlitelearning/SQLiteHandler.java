package com.example.sqlitelearning;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHandler extends SQLiteOpenHelper {

    public SQLiteHandler(Context context) {
        super(context);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//here we will c reate the table for the db


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
