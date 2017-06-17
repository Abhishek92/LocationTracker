package com.android.locationtracker.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

import java.io.IOException;

/**
 * Created by hp pc on 17-06-2017.
 */

public enum DBManager {

    INSTANCE;
    private DaoSession daoSession;
    public void initDatabase(Context context) throws IOException {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "angrybird-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession()
    {
        return daoSession;
    }
}
