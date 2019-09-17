package com.example.cms_01.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

public class TimetableDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Cms.db";
    public static final String TABLE_NAME="cms_table";
    public static final String DB_PATH="";
  //  public static final Context mycontaxt;


    public static final String COL_ID="TASK_ID";
    public  String COL_SUBJECT="SUBJECT";
    public static final String COL_BATCH="BATCH";
    public static final String COL_VENUE="VENUE";
    public static final String COL_DATE="DATE";
    public static final String COL_DURATIONST="DURATIONST";
    public static final String COL_DURATIONTO="DURATIONTO";
    public static final String COL_TYPE="TYPE";
    public static final String COL_NOTICE="NOTICE";
    private static final String TAG ="TimetableDBHelper" ;


    public TimetableDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

            if(Build.VERSION.SDK_INT>=15) {
               // DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
            }
            else{
                  //  DB_PATH= Environment.getDataDirectory()+"/data/"+context.getPackageName()+"/databases/";
            }

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("create table "+TABLE_NAME+"(TASK_ID INTEGER PRIMARY KEY AUTOINCREMENT,SUBJECT TEXT,BATCH TEXT,VENUE TEXT,DATE TEXT,DURATIONST TEXT,DURATIONTO TEXT,TYPE TEXT,NOTICE TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertdata(String subject,String batch,String venue,String date,String durationst,String durationto,String type,String notice){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_SUBJECT,subject);
        contentValues.put(COL_BATCH,batch);
        contentValues.put(COL_VENUE,venue);
        contentValues.put(COL_DATE,date);
        contentValues.put(COL_DURATIONST,durationst);
        contentValues.put(COL_DURATIONTO,durationto);
        contentValues.put(COL_TYPE,type);
        contentValues.put(COL_NOTICE,notice );

        long result=db.insert(TABLE_NAME,null,contentValues);

        if(result==-1){
            return false;
        }
        else{
            return true;
        }



    }


   // public synchronized void close(){
       // if(myDatabase==)

    public Cursor viewData(){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="Select * from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);

        return cursor;
    }

    public Cursor getTaskID(String subject){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME +
                " WHERE " + COL_SUBJECT + " = '" + subject + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }


    public boolean updateName(String oldsubject, String date, String batch, String venue, String notice, String durationst, String durationto){
        SQLiteDatabase db = this.getWritableDatabase();
   /*     String query = "UPDATE " + TABLE_NAME + " SET " + COL_SUBJECT +
                " = '" + newsubject + "' WHERE " + COL_SUBJECT + " = '" + oldsubject + "'" +
                " AND " + COL_BATCH + " = '" + oldsubject + "'"; */

        ContentValues sv = new ContentValues();
        sv.put(COL_SUBJECT,oldsubject );
        sv.put(COL_BATCH, batch);
        sv.put(COL_VENUE, venue);
        sv.put(COL_NOTICE, notice);
        sv.put(COL_DURATIONST, durationst);
        sv.put(COL_DURATIONTO, durationto);
        sv.put(COL_DATE, date);

        db.update(TABLE_NAME, sv, "SUBJECT = ?", new String[] { oldsubject });
        return true;
    }

    public Integer deleteTask(String  name){
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME,"SUBJECT= ?",new String[]{name});

       /* String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL_SUBJECT + " = '" + id + "'" +
                " AND " + COL_BATCH + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
        */
    }
    public Cursor searchTaskData(String text){

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_SUBJECT + " Like '%" + text + "%'";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;

    }



    }
