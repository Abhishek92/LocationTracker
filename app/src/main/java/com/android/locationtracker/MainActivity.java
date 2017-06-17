package com.android.locationtracker;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.locationtracker.database.DBManager;
import com.android.locationtracker.database.LocationData;
import com.android.locationtracker.util.DateTimeUtil;
import com.android.locationtracker.util.FileUtils;

public class MainActivity extends BaseActivity {


    private boolean startLocationTracking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button trackLocation = (Button) findViewById(R.id.btn_start_stop_loc);
        trackLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!startLocationTracking) {
                    startLocationTracking = true;
                    trackLocation.setText(R.string.stop_location_tracking_txt);
                    startLocationTracking(10);
                    Toast.makeText(MainActivity.this, R.string.location_track_start_msg, Toast.LENGTH_SHORT).show();
                } else {
                    startLocationTracking = false;
                    trackLocation.setText(R.string.start_location_tracking_txt);
                    removeLocationUpdates();
                    Toast.makeText(MainActivity.this, R.string.location_track_stop_msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    @Override
    protected void updateLocationBasedOnDistance(Location location) {

        LocationData locationData = new LocationData();
        locationData.setLatitiude(location.getLatitude());
        locationData.setLongitude(location.getLongitude());
        locationData.setTime(DateTimeUtil.getCurrentDateTime());

        //Convert speed to KM/HR
        double speed = location.getSpeed() * 3.6;
        if(speed >= 80.0) {
            removeLocationUpdates();
            startLocationTracking(30 * MILISECONDS);
            locationData.setCurrTimeIntervel(30);
        }
        else if(speed < 80.0 && speed >= 60) {
            removeLocationUpdates();
            startLocationTracking(60 * MILISECONDS);
            locationData.setCurrTimeIntervel(60);
        }
        else if(speed < 60.0 && speed >= 300) {
            removeLocationUpdates();
            startLocationTracking(120 * MILISECONDS);
            locationData.setCurrTimeIntervel(120);
        }
        else if(speed < 30.0) {
            removeLocationUpdates();
            startLocationTracking(300 * MILISECONDS);
            locationData.setCurrTimeIntervel(300);
        }
        else {
            removeLocationUpdates();
            startLocationTracking(10 * MILISECONDS);
        }
        FileUtils.saveLocationDataToFile(this, locationData);
        DBManager.INSTANCE.getDaoSession().getLocationDataDao().insert(locationData);
    }
}
