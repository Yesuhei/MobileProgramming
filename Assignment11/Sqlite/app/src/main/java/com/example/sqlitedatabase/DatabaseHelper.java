package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student.db";
    private static final String TABLE_NAME = "student";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
    private static final String COL_AGE = "AGE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,  1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_NAME +" ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, "
                + COL_AGE + " INTEGER"
                + ")"

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    boolean insertData(String name,String age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME,name);
        values.put(COL_AGE,age);
        long result = db.insert(TABLE_NAME, null,values);
        return result != -1;

    }

    Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);

        return res;
    }

    boolean updateData(String id,String name,String age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ID,id);
        values.put(COL_NAME,name);
        values.put(COL_AGE,age);
        long result = db.update(TABLE_NAME,values,"id = ?",new String[]{id});
        return result != -1;

    }
    Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"id = ?",new String[]{id});
    }
}
