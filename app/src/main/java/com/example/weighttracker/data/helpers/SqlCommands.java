package com.example.weightTrackerApp.data.helpers;

import com.example.weightTrackerApp.data.model.SqlDbContract;

public final class SqlCommands {
    public static final String CREATE_DB_SCHEMA ="";
    public static final String CREATE_INV_TABLE =
            "CREATE TABLE " + SqlDbContract.weightEntry.TABLE_NAME + " (" +
                    SqlDbContract.weightEntry._ID + " INTEGER PRIMARY KEY," +
                    SqlDbContract.weightEntry.COLUMN_NAME_NAME + " TEXT," +
                    SqlDbContract.weightEntry.COLUMN_NAME_TYPE + " TEXT," +
                    SqlDbContract.weightEntry.COLUMN_NAME_COUNT + " TEXT," +
                    SqlDbContract.weightEntry.COLUMN_NAME_DATE + " TEXT)";
    public static final String CREATE_AUTH_TABLE =
            "CREATE TABLE " + SqlDbContract.AuthenticationEntry.TABLE_NAME + " (" +
                    SqlDbContract.AuthenticationEntry._ID + " INTEGER PRIMARY KEY," +
                    SqlDbContract.AuthenticationEntry.COLUMN_NAME_NAME + " TEXT," +
                    SqlDbContract.AuthenticationEntry.COLUMN_NAME_USERNAME + " TEXT," +
                    SqlDbContract.AuthenticationEntry.COLUMN_NAME_PASSWORD + " TEXT," +
                    SqlDbContract.AuthenticationEntry.COLUMN_NAME_LAST_LOGIN + " TEXT)";
}
