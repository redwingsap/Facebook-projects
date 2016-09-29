package com.arjun.sprint2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by Arjun on 22-08-2016.
 */

public class  DBhelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    public DBhelper(Context context) {
        super(context, "DBFacebok", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table login (id integer primary key auto increment, uname text, pwd text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists login");
        onCreate(db);
    }

    public String insertData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String log1 = "insert into login (uname,pwd) values('arjun@gmail.com','arjun123')";
        db.execSQL(log1);
        return log1;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this .getWritableDatabase();
        Cursor res = db.rawQuery("select * from login",null);
        return  res;
    }

    public String fblogin (String username)
    {
        SQLiteDatabase db = this .getWritableDatabase();
        Cursor csr = db.query("login", null, " uname=?",new String[] { username }, null, null, null);
        if (csr.getCount() < 1) {
            csr.close();
            return "NOT EXIST";
        }
        csr.moveToFirst();
        String password = csr.getString(csr.getColumnIndex("pwd"));
        csr.close();
        return password;


    }

}
