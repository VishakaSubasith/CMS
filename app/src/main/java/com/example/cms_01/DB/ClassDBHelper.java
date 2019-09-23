package com.example.cms_01.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.provider.BaseColumns._ID;
import static androidx.constraintlayout.widget.Constraints.TAG;
import static com.example.cms_01.DB.UserMaster.Users.COLUMN_NAME_DAY_;
import static com.example.cms_01.DB.UserMaster.Users.COLUMN_NAME_LOCATION_;
import static com.example.cms_01.DB.UserMaster.Users.COLUMN_NAME_NAME;
import static com.example.cms_01.DB.UserMaster.Users.COLUMN_NAME_YEAR_;
import static com.example.cms_01.DB.UserMaster.Users.COLUMN_NAME__SUBJECT;
import static com.example.cms_01.DB.UserMaster.Users.TABLE_NAME;

public class ClassDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="cms.db";

    public ClassDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       String SQL_CREATE_ENTRIES=
        "CREATE TABLE "+  TABLE_NAME + " ("+
        UserMaster.Users._ID +" INTEGER PRIMARY KEY,"+
        COLUMN_NAME_NAME + " TEXT," +
        COLUMN_NAME__SUBJECT +" TEXT,"+
        COLUMN_NAME_YEAR_ +" TEXT,"+
        COLUMN_NAME_LOCATION_+ " TEXT,"+
                COLUMN_NAME_DAY_ +" TEXT)";

       sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addclass(String name, String subject, String year, String location, String day){

        SQLiteDatabase db= getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME_NAME, name);
        values.put(COLUMN_NAME__SUBJECT, subject);
        values.put(COLUMN_NAME_YEAR_, year);
        values.put(COLUMN_NAME_LOCATION_, location);
        values.put(COLUMN_NAME_DAY_, day);
        long newrowID = db.insert(TABLE_NAME,null,values);
        if (newrowID == -1) {
            return false;
        } else {
            return true;
        }
    }
public Cursor viewdata(){
        SQLiteDatabase db= this.getReadableDatabase();
        String query= "Select * from "+TABLE_NAME;
    Cursor cur =db.rawQuery(query,null);
    return cur;
}
public Cursor getItemID(String classname, String sub, String year,String locate) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + _ID + " FROM " + TABLE_NAME +
                " WHERE " + COLUMN_NAME_NAME + " = '" + classname + "'"+
                " AND " + COLUMN_NAME__SUBJECT + " = '" + sub + "'" +
                " AND " + COLUMN_NAME_YEAR_ + " = '" + year + "'" +
                " AND " + COLUMN_NAME_LOCATION_ + " = '" + locate + "'";
        Cursor data=db.rawQuery(query,null);
        return data;
    }

    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME_NAME +
                " = '" + newName + "' WHERE " + _ID + " = '" + id + "'" +
                " AND " + COLUMN_NAME_NAME + " = '" + oldName + "'" ;
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }
    public void updatesubject(String newsub, int id, String oldsub){
        SQLiteDatabase db = this.getWritableDatabase();
        String query1 = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME__SUBJECT +
                " = '" + newsub + "' WHERE " + _ID + " = '" + id + "'" +
                " AND " + COLUMN_NAME__SUBJECT + " = '" + oldsub + "'";
        Log.d(TAG, "updateName: query: " + query1);
        Log.d(TAG, "updateName: Setting name to " + newsub);
        db.execSQL(query1);
    }
    public void updateyear(String newyear, int id, String oldyear){
        SQLiteDatabase db = this.getWritableDatabase();
        String query1 = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME_YEAR_ +
                " = '" + newyear + "' WHERE " + _ID + " = '" + id + "'" +
                " AND " + COLUMN_NAME_YEAR_ + " = '" + oldyear + "'";
        Log.d(TAG, "updateName: query: " + query1);
        Log.d(TAG, "updateName: Setting name to " + newyear);
        db.execSQL(query1);
    }
    public void updatelocatation(String newloacte, int id, String oldlocate){
        SQLiteDatabase db = this.getWritableDatabase();
        String query1 = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME_LOCATION_ +
                " = '" + newloacte + "' WHERE " + _ID + " = '" + id + "'" +
                " AND " + COLUMN_NAME_LOCATION_ + " = '" + oldlocate + "'";
        Log.d(TAG, "updateName: query: " + query1);
        Log.d(TAG, "updateName: Setting name to " + newloacte);
        db.execSQL(query1);
    }
    public void updatedays(String newday, int id, String oldday){
        SQLiteDatabase db = this.getWritableDatabase();
        String query1 = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME_DAY_ +
                " = '" + newday + "' WHERE " + _ID + " = '" + id + "'" +
                " AND " + COLUMN_NAME_DAY_ + " = '" + oldday + "'";
        Log.d(TAG, "updateName: query: " + query1);
        Log.d(TAG, "updateName: Setting name to " + newday);
        db.execSQL(query1);
    }


    /**
     * Delete from database
     */

    public void deleteName(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + _ID + " = '" + id + "'" +
                " AND " + COLUMN_NAME_NAME + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }

    public Cursor searchclassData(String text){

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME_NAME + " Like '%" + text + "%'";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;

    }

}


