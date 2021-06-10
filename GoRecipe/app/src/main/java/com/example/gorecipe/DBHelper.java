package com.example.gorecipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "goRecipe.db", null, 1);
    }
    public static final String DBNAME = "goRecipe.db";
    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE users(username TEXT primary key,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("DROP TABLE if exists users");

    }
    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);

        long result = MyDB.insert("users",null,contentValues);
        if(result == -1) return false;
        else
            return true;

    }
    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE username = ? and password = ?",new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
