package com.example.cms_01.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ExpenseDBHelper extends SQLiteOpenHelper{


    public static final String expDBname = "Expense1.db";
    public static final String TableName = "insertexpense";
    public static final String EXPCOL01 = "ID";
    public static final String EXPCOL02 = "Name";
    public static final String EXPCOL03 = "category";
    public static final String EXPCOL04 = "amount";
    public static final String EXPCOL05 = "date";


    public ExpenseDBHelper(Context context) {
        super(context, expDBname, null, 1);
    SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TableName +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, " +
                "category TEXT, amount TEXT, date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TableName );
        onCreate(db);

    }

    public boolean insertExpData(String Name, String cate, String amount, String date){

    SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EXPCOL02,Name);
        contentValues.put(EXPCOL03,cate);
        contentValues.put(EXPCOL04,amount);
        contentValues.put(EXPCOL05,date);

       long result = db.insert(TableName, null,contentValues);

        if(result == -1){
            return false;
        }else{

            return true;
        }
    }

    public Cursor viewExpData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data =  db.rawQuery("SELECT * FROM " + TableName,null);
        return data;

    }
    public Cursor getExpenseID(String exptuname){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + EXPCOL02 + " , " +  EXPCOL03 + " , " + EXPCOL04 + " , " + EXPCOL05 + " FROM " + TableName +
                " WHERE " + EXPCOL02 + " = '" + exptuname + "'";

        Cursor data1 = db.rawQuery(query, null);
        return data1;
    }

    public boolean updateExp(String Name, String cate, String amount, String date){

        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(EXPCOL02, Name);
        cv.put(EXPCOL03, cate);
        cv.put(EXPCOL04, amount);
        cv.put(EXPCOL05, date);

        db1.update(TableName,cv, "Name = ?", new String[] { Name });
        return true;
//return true;
      /*  String query1 = "UPDATE " +Tabl

      eName+ " SET "+EXPCOL03+ " ='"+cate+"' , " +EXPCOL04+ "= '" +amount+ "' , "+EXPCOL05+ "= '"+date+"' , "+ " WHERE " + EXPCOL02 + " = '" +  Name + "'";
        db1.execSQL(query1);*/

    }

    public Integer delete(String name){
        SQLiteDatabase db1 = this.getWritableDatabase();

        return db1.delete(TableName, "Name = ?", new String[] { name });
    }

    public Cursor searchExpData(String text){

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TableName + " WHERE " + EXPCOL02 + " Like '%" + text + "%'";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;

    }

    public Cursor getDateExp(String s1, String s2){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data =  db.rawQuery("SELECT * FROM " + TableName + " WHERE " +EXPCOL05 + " BETWEEN '" + s1 + "' AND '" + s2 + "'",null);

        return data;

    }

}
