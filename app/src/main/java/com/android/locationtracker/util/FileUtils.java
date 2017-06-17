package com.android.locationtracker.util;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.android.locationtracker.database.LocationData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hp pc on 17-06-2017.
 */

public class FileUtils {

    private FileUtils()
    {

    }

    public static void saveLocationDataToFile(Context context, LocationData locationData)
    {
        String fileName = "locationdata.txt";
        try {
            String sBody = "Date & Time:  "+locationData.getTime()+"\n"
                    +"Latitude:   "+locationData.getLatitiude()+"\n"
                    +"Longitude:   "+locationData.getLongitude()+"\n"
                    +"Current time intervel:   "+locationData.getCurrTimeIntervel()+"\n"
                    +"Next time intervel:   "+locationData.getNextTimeIntervel()+"\n";

            File gpxfile = new File(Environment.getExternalStorageDirectory(), fileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
