package com.mirroredlineprops.alex.rebelliondice;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mirroredlineprops.alex.rebelliondice.dbhelpers.StatsDbHelper;


public class StatsWizardActivity extends Activity {
    public final static String ROW_ID = "com.mirroredlineprops.alex.rebelliondice.ROW_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_wizard);

        StatsDbHelper stats = new StatsDbHelper(getBaseContext());
        SQLiteDatabase statsDb= stats.getReadableDatabase();
        Cursor c = StatsDbHelper.getCharsCursor(statsDb);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.stats_wizard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
