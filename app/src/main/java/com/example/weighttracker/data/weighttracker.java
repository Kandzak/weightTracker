package com.example.weightTrackerApp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.weightTrackerApp.data.helpers.SqlDbHelper;
import com.example.weightTrackerApp.data.model.SqlDbContract;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class weightDataSource {

    private SqlDbHelper DbHelper;

    public weightDataSource(Context context) {
        DbHelper = new SqlDbHelper(context);
    }

    /*
        Private Helpers
    */
    public Cursor queryweightDatabase(String[] projection, @Nullable String selection,
                                      @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        // Get DB
        SQLiteDatabase db = DbHelper.getReadableDatabase();
        // Query and return cursor
        return db.query(
                SqlDbContract.weightEntry.TABLE_NAME,          // The table to query
                projection,         // The array of columns to return (pass null to get all)
                selection,          // The columns for the WHERE clause
                selectionArgs,      // The values for the WHERE clause
                null,      // don't group the rows
                null,       // don't filter by row groups
                sortOrder           // The sort order
        );
    }

    public long insertweightDatabase(String productName, String productType, String productCount) {
        // Get DB
        SQLiteDatabase db = DbHelper.getWritableDatabase();
        // Create content values
        ContentValues values = new ContentValues();
        values.put(SqlDbContract.weightEntry.COLUMN_NAME_NAME, productName);
        values.put(SqlDbContract.weightEntry.COLUMN_NAME_TYPE, productType);
        values.put(SqlDbContract.weightEntry.COLUMN_NAME_COUNT, productCount);
        values.put(SqlDbContract.weightEntry.COLUMN_NAME_DATE, java.text.DateFormat.getDateTimeInstance().format(new Date()));
        // Insert the new row, returning the primary key value of the new row
        return db.insert(SqlDbContract.weightEntry.TABLE_NAME, null, values);
    }

    public boolean updateweightDatabase(String productId, String newCount) {
        // Get DB
        SQLiteDatabase db = DbHelper.getWritableDatabase();
        // New value for count column
        ContentValues values = new ContentValues();
        values.put(SqlDbContract.weightEntry.COLUMN_NAME_COUNT, newCount);
        // Which row to update, based on the title
        String selection = SqlDbContract.weightEntry._ID + " LIKE ?";
        String[] selectionArgs = { productId };
        // Call for Update
        return db.update(
                SqlDbContract.weightEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs) > 0;
    }

    public boolean deleteweightDatabase(String productId) {
        // Get DB
        SQLiteDatabase db = DbHelper.getWritableDatabase();
        // Build Delete Query
        String selection = SqlDbContract.weightEntry._ID + " LIKE ?";
        String[] selectionArgs = { productId };
        // Call for Delete
        return db.delete(
                SqlDbContract.weightEntry.TABLE_NAME,
                selection,
                selectionArgs) > 0;
    }

    public boolean deleteAllweightData() {
        // Get DB
        SQLiteDatabase db = DbHelper.getWritableDatabase();
        // Call for Delete
        return db.delete(
                SqlDbContract.weightEntry.TABLE_NAME,
                null,
                null) > 0;
    }
}
