package com.android.locationtracker;

import android.app.Application;

import com.android.locationtracker.database.DBManager;

import java.io.IOException;

/**
 * Created by hp pc on 17-06-2017.
 */

public class LocationTrackerApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            DBManager.INSTANCE.initDatabase(getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
