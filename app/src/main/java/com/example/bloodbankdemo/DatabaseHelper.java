package com.example.bloodbankdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
 public static final String DB_NAME="DB_BLOOD";
    public static final String TABLE_NAME="REG_TABLE";
    public static final String COL_ID="ID";
    public static final String COL_NAME="NAME";
    public static final String COL_PHONE="PHONE";
    public static final String COL_EMAIL="EMAIL";
    public static final String COL_PASSWORD="PASSWORD";
    public static final String COL_GENDER="GENDER";
    public DatabaseHelper(Context context){
        super(context,DB_NAME,null,1);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+ TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT ,PHONE INTEGER ,EMAIL TEXT, PASSWORD TEXT, GENDER TEXT) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);

    }

    public Boolean insertData(String name, String phone, String pass, String email, String g) {
        SQLiteDatabase sql= this.getReadableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_NAME,name);
        cv.put(COL_PHONE,phone);
        cv.put(COL_PASSWORD,pass);
        cv.put(COL_EMAIL,email);
        cv.put(COL_GENDER,g);
        long result=sql.insert(TABLE_NAME,null,cv);
        sql.close();
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getAllData() {
    SQLiteDatabase sql= this.getReadableDatabase();
    Cursor cursor=sql.rawQuery("Select * from " + TABLE_NAME,null);
    return cursor;
    }

    public int DeleteData(String no) {
    SQLiteDatabase sql= this.getWritableDatabase();
    int i= sql.delete(TABLE_NAME," PHONE = ? ",new String []{no});
    return i;
    }

    public Boolean updateData(String id, String name, String phone, String pass, String email) {
    SQLiteDatabase sql= this.getWritableDatabase();
    ContentValues cv= new ContentValues();
    cv.put(COL_NAME,name);
    cv.put(COL_EMAIL,email);
    cv.put(COL_PASSWORD,pass);
    cv.put(COL_PHONE,phone);
  int result= sql.update(TABLE_NAME,cv,"ID = ? ", new String[]{id} );
    if(result>0){
        return  true;
    }
    else{return false;}
    }

    public boolean checkuser(String user, String pass) {
    SQLiteDatabase sql =this.getReadableDatabase();
    String [] columns={COL_EMAIL};
    String selection=COL_EMAIL+" =? "+" AND "+COL_PASSWORD;
    String [] selectargs={user,pass};
    Cursor cursor= sql.query(TABLE_NAME,columns,selection,selectargs,null,null,null);
    int c_count= cursor.getCount();
        cursor.close();
        sql.close();
        if(c_count>0){
            return true;
        }else{
            return false;
        }
    }

}
