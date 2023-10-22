package com.example.weightTrackerApp.ui.home;

import android.content.Context;
import android.database.Cursor;
import android.provider.BaseColumns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weightTrackerApp.data.weightDataSource;
import com.example.weightTrackerApp.data.helpers.SqlDbHelper;
import com.example.weightTrackerApp.data.model.SqlDbContract;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class HomeViewModel extends ViewModel {

    private weightDataSource dataSource;

    public HomeViewModel() { }

    // Initialize the Data Source  Provider
    public void InitializeDataProvider(Context context) {
        dataSource = new weightDataSource(context);
    }

    public ArrayList<HashMap> GetRecords() throws IOException {
        try {
            // Projection
            String[] projection = {
                    BaseColumns._ID,
                    SqlDbContract.weightEntry.COLUMN_NAME_NAME,
                    SqlDbContract.weightEntry.COLUMN_NAME_TYPE,
                    SqlDbContract.weightEntry.COLUMN_NAME_COUNT
            };
            // Query Db
            Cursor cursor = dataSource.queryweightDatabase(projection, null, null, null);
            return SqlDbHelper.GetAll(cursor);
        } catch (Exception e) {
            throw new IOException("Error getting all records", e);
        }
    }
}