package com.example.cms_01.DB;

import android.provider.BaseColumns;

public final class UserMaster {


    protected static class Users implements BaseColumns{
        public static final String TABLE_NAME="classes";
        public static final String COLUMN_NAME_NAME="name";
        public static final String COLUMN_NAME__SUBJECT="subject";
        public static final String COLUMN_NAME_YEAR_="year";
        public static final String COLUMN_NAME_LOCATION_="location";
        public static final String COLUMN_NAME_DAY_="day";

    }
}
