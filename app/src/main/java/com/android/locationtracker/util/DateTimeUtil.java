package com.android.locationtracker.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hp pc on 17-06-2017.
 */

public class DateTimeUtil {
    private DateTimeUtil()
    {

    }

    public static String getCurrentDateTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }
}
