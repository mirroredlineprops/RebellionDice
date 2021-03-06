package com.mirroredlineprops.alex.rebelliondice.adapters;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mirroredlineprops.alex.rebelliondice.dbhelpers.RefDbHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alex.costanzo on 10/24/2014.
 */
public class RefAdapter {

    protected static final String TAG = "DataAdapter";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private RefDbHelper mDbHelper;

    public RefAdapter(Context context)
    {
        this.mContext = context;
        mDbHelper = new RefDbHelper(mContext);
    }

    public RefAdapter createDatabase() throws SQLException
    {
        try
        {
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public RefAdapter open() throws SQLException
    {
        try
        {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "open >>" + mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }


    public List<String> getSpecies() {
        Cursor refData = getData("SELECT _id, Name FROM race");
        refData.moveToFirst();
        List<String> species = new ArrayList<String>();
        do {
            species.add(refData.getString(1));
        }
        while (refData.moveToNext());
        return species;
    }

    public Cursor getSpeciesStats(String speciesName) {
        return getData("SELECT * FROM race WHERE Name=\"" + speciesName + "\"");
    }

    public Map<String, List<String>> getCareers() {
        Cursor refData = getData("SELECT * FROM trees");
        refData.moveToFirst();
        Map<String, List<String>> careerMap = new HashMap<String, List<String>>();
        do {
            String career = refData.getString(1);
            String special = refData.getString(2);
            List<String> data;
            if (careerMap.get(career) == null) {
                data = new ArrayList<String>();
            }
            else {
                data = careerMap.get(career);
            }
            data.add(special);
            careerMap.put(career, data);
        }
        while (refData.moveToNext());
        return careerMap;
    }

    public Cursor getData(String sql)
    {
        try
        {
            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur!=null)
            {
                mCur.moveToNext();
            }
            return mCur;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getTestData >>" + mSQLException.toString());
            throw mSQLException;
        }
    }
}
