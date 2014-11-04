package com.mirroredlineprops.alex.rebelliondice.dbhelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mirroredlineprops.alex.rebelliondice.contracts.CharContract;
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

    public static Cursor getCharsCursor(SQLiteDatabase statsDb) {
        String[] projection = {
                CharContract.CharEntry._ID,
                CharContract.CharEntry.COLUMN_NAME_NAME
        };

        String sortOrder = CharContract.CharEntry.COLUMN_NAME_ENTRY_ID + " DESC";
        // Define 'where' part of query.
        String selection = CharContract.CharEntry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
        // Specify arguments in placeholder order.
        int rowId = 1;
        String[] selectionArgs = { String.valueOf(rowId) };

        Cursor c = statsDb.query(
                CharContract.CharEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null, // group by
                null, // having
                sortOrder
        );
        return c;
    }

}