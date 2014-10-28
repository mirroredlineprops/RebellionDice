package com.mirroredlineprops.alex.rebelliondice.dbhelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mirroredlineprops.alex.rebelliondice.dbhelpers.DbStrings;

public class StatsDbHelper extends SQLiteOpenHelper {



    public StatsDbHelper(Context context) {
        super(context, DbStrings.DATABASE_NAME, null, DbStrings.DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbStrings.SQL_CREATE_WEAPON_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(DbStrings.SQL_DELETE_WEAPON_ENTRIES);
        onCreate(db);
    }

}