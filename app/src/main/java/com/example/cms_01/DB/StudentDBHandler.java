package com.example.cms_01.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class StudentDBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME="Student.db";

    public StudentDBHandler(Context context){super(context,DB_NAME,null,1);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_ENTRIES="CREATE TABLE "+StudentDB.students.TABLE_NAME+" ( "
                                    +StudentDB.students._ID+ " INTEGER PRIMARY KEY , "
                                    +StudentDB.students.COLUMN_NAME_FNAME+ " TEXT , "
                                    +StudentDB.students.COLUMN_NAME_LNAME+ " TEXT , "
                                    +StudentDB.students.COLUMN_NAME_GENDER+ " TEXT , "
                                    +StudentDB.students.COLUMN_NAME_BDAY+" TEXT , "
                                    +StudentDB.students.COLUMN_NAME_BATCH+" TEXT , "
                                    +StudentDB.students.COLUMN_NAME_SCLOOL+" TEXT )";


                sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addStudent(String fname,String lname,String gender,String bday,String batch,String school){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(StudentDB.students.COLUMN_NAME_FNAME,fname);
        values.put(StudentDB.students.COLUMN_NAME_LNAME,lname);
        values.put(StudentDB.students.COLUMN_NAME_GENDER,gender);
        values.put(StudentDB.students.COLUMN_NAME_BDAY,bday);
        values.put(StudentDB.students.COLUMN_NAME_BATCH,batch);
        values.put(StudentDB.students.COLUMN_NAME_SCLOOL,school);



        long newrowID =db.insert(StudentDB.students.TABLE_NAME,null,values);

        Log.e("insert successfull","insert success");


    }

    public Cursor showStudents(){

        SQLiteDatabase db = this.getReadableDatabase();

        String showStudents= "SELECT "+StudentDB.students.COLUMN_NAME_FNAME+" FROM "+StudentDB.students.TABLE_NAME;

        Cursor cursor = db.rawQuery(showStudents,null);

        return cursor;





    }

    public Cursor getStudent(String FName){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();


        String query = "SELECT "+StudentDB.students.COLUMN_NAME_FNAME+" , "+StudentDB.students.COLUMN_NAME_LNAME+" , "+StudentDB.students.COLUMN_NAME_GENDER+" , " +StudentDB.students.COLUMN_NAME_BDAY+" , "+StudentDB.students.COLUMN_NAME_BATCH+" , "+StudentDB.students.COLUMN_NAME_SCLOOL+" FROM  "+StudentDB.students.TABLE_NAME+" WHERE "+StudentDB.students.COLUMN_NAME_FNAME+ " = '"+FName+"'";

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);



        return cursor;

    }




    public void UpdateStudent(String fname,String lname,String gender,String bday,String batch,String scl){


        SQLiteDatabase db= this.getWritableDatabase();

   String selection = StudentDB.students.COLUMN_NAME_FNAME +" ? ";

            String query =" UPDATE "+StudentDB.students.TABLE_NAME+" SET "+StudentDB.students.COLUMN_NAME_LNAME+" ='"+lname+"',"
                    +StudentDB.students.COLUMN_NAME_GENDER+" ='"+gender+"' ,"+StudentDB.students.COLUMN_NAME_BDAY+" = '"+bday+"',"
                    +StudentDB.students.COLUMN_NAME_BATCH+" = '"+batch+"',"+StudentDB.students.COLUMN_NAME_SCLOOL+"= '"+scl+"' WHERE "+StudentDB.students.COLUMN_NAME_FNAME+" = '"+fname+"'";
          db.execSQL(query);








    }
    public void DeleteStudent(String name){

        SQLiteDatabase db= this.getWritableDatabase();

        String deleteQuery="DELETE FROM "+StudentDB.students.TABLE_NAME+ " WHERE "+StudentDB.students.COLUMN_NAME_FNAME+"='"+name+"'";

            db.execSQL(deleteQuery);

    }
    public Cursor searchStudentData(String fname){

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " +StudentDB.students.TABLE_NAME+" WHERE " +StudentDB.students.COLUMN_NAME_FNAME+ " Like '%" + fname + "%'";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;

    }

}
