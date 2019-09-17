package com.example.cms_01.DB;

import android.provider.BaseColumns;

public final class StudentDB {

    private StudentDB(){}


    protected static class students implements BaseColumns{

        public static final String TABLE_NAME="Students";
        public static final String COLUMN_NAME_FNAME="fname";
        public static final String COLUMN_NAME_LNAME="lname";
        public static final String COLUMN_NAME_GENDER="gender";
        public static final String COLUMN_NAME_BDAY="bday";
        public static final String COLUMN_NAME_BATCH="batch";
        public static final String COLUMN_NAME_SCLOOL="sclool";







    }



}
