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
        db.execSQL(DbStrings.SQL_CREATE_ARMOR_ENTRIES);
        db.execSQL(DbStrings.SQL_CREATE_GEAR_ENTRIES);
        db.execSQL(DbStrings.SQL_CREATE_STATE_ENTRIES);
        db.execSQL(DbStrings.SQL_CREATE_CHAR_ENTRIES);
        db.execSQL(DbStrings.SQL_CREATE_SKILLS_ENTRIES);
        db.execSQL(DbStrings.SQL_CREATE_TALENT_ENTRIES);
        db.execSQL(DbStrings.SQL_CREATE_TREE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(DbStrings.SQL_DELETE_WEAPON_ENTRIES);
        db.execSQL(DbStrings.SQL_DELETE_ARMOR_ENTRIES);
        db.execSQL(DbStrings.SQL_DELETE_GEAR_ENTRIES);
        db.execSQL(DbStrings.SQL_DELETE_STATE_ENTRIES);
        db.execSQL(DbStrings.SQL_DELETE_CHAR_ENTRIES);
        db.execSQL(DbStrings.SQL_DELETE_SKILLS_ENTRIES);
        db.execSQL(DbStrings.SQL_DELETE_TALENT_ENTRIES);
        db.execSQL(DbStrings.SQL_DELETE_TREE_ENTRIES);
        onCreate(db);
    }

}