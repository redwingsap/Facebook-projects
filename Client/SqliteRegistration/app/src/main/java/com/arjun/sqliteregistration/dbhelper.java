package com.arjun.sqliteregistration;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Arjun on 24-10-2016.
 */
public class dbhelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    public dbhelper(Context context) {
        super(context, "DBLogin", null, 1);
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

    public String login (String username)
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
