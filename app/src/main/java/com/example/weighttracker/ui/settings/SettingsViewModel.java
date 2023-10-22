package com.example.weightTrackerApp.ui.settings;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weightTrackerApp.data.weightDataSource;

import java.util.jar.Manifest;

public class SettingsViewModel extends ViewModel {

    private weightDataSource dataSource;

    public SettingsViewModel() {

    }

    // Initialize the Data Source  Provider
    public void InitializeDataProvider(Context context) {
        dataSource = new weightDataSource(context);
    }

    // Used to clear out the data in the weight table
    public boolean DeleteAllweightData() {
        return dataSource.deleteAllweightData();
    }

}
