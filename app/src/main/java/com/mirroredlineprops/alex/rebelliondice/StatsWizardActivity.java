package com.mirroredlineprops.alex.rebelliondice;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.mirroredlineprops.alex.rebelliondice.adapters.RefAdapter;
import com.mirroredlineprops.alex.rebelliondice.contracts.CharContract;
import com.mirroredlineprops.alex.rebelliondice.dbhelpers.StatsDbHelper;


public class StatsWizardActivity extends Activity {
    public final static String ROW_ID = "com.mirroredlineprops.alex.rebelliondice.ROW_ID";
    public final static String SPECIES = "com.mirroredlineprops.alex.rebelliondice.SPECIES";
    private long rowId;
    private int totalXp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_wizard);
        Intent intent = getIntent();
        rowId = intent.getLongExtra(StatsWizardActivity.ROW_ID, -1);
        String species = intent.getStringExtra(StatsWizardActivity.SPECIES);

        RefAdapter refAdapter = new RefAdapter(this);
        refAdapter.createDatabase();
        refAdapter.open();
        Cursor statsCursor = refAdapter.getSpeciesStats(species);

        if (statsCursor.moveToFirst()) {
            ((EditText) findViewById(R.id.brawnEdit)).setText(statsCursor.getString(2));
            ((EditText) findViewById(R.id.agilityEdit)).setText(statsCursor.getString(3));
            ((EditText) findViewById(R.id.intellectEdit)).setText(statsCursor.getString(4));
            ((EditText) findViewById(R.id.cunningEdit)).setText(statsCursor.getString(5));
            ((EditText) findViewById(R.id.willpowerEdit)).setText(statsCursor.getString(6));
            ((EditText) findViewById(R.id.presenceEdit)).setText(statsCursor.getString(7));

            ((EditText) findViewById(R.id.soakEdit)).setText(statsCursor.getString(2));
            ((EditText) findViewById(R.id.woundsEdit)).setText(statsCursor.getInt(8) + statsCursor.getInt(2) + "");
            ((EditText) findViewById(R.id.strainEdit)).setText(statsCursor.getInt(9) + statsCursor.getInt(6) + "");
            ((EditText) findViewById(R.id.rangeDefEdit)).setText("0");
            ((EditText) findViewById(R.id.meleeDefEdit)).setText("0");
            totalXp = Integer.valueOf(statsCursor.getString(10));
            ((EditText) findViewById(R.id.xpEdit)).setText(totalXp + "");
        }


        refAdapter.close();
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

    public void nextWizard(View view) {
        StatsDbHelper statsDbHelper = new StatsDbHelper(getBaseContext());
        SQLiteDatabase db = statsDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CharContract.CharEntry.COLUMN_NAME_BRAWN, ((EditText) findViewById(R.id.brawnEdit)).getText().toString());
        values.put(CharContract.CharEntry.COLUMN_NAME_AGILITY, ((EditText) findViewById(R.id.agilityEdit)).getText().toString());
        values.put(CharContract.CharEntry.COLUMN_NAME_INTELLECT, ((EditText) findViewById(R.id.intellectEdit)).getText().toString());
        values.put(CharContract.CharEntry.COLUMN_NAME_CUNNING, ((EditText) findViewById(R.id.cunningEdit)).getText().toString());
        values.put(CharContract.CharEntry.COLUMN_NAME_WILLPOWER, ((EditText) findViewById(R.id.willpowerEdit)).getText().toString());
        values.put(CharContract.CharEntry.COLUMN_NAME_PRESENCE, ((EditText) findViewById(R.id.presenceEdit)).getText().toString());
        values.put(CharContract.CharEntry.COLUMN_NAME_SOAK, ((EditText) findViewById(R.id.soakEdit)).getText().toString());
        values.put(CharContract.CharEntry.COLUMN_NAME_WOUNDS, "0");
        values.put(CharContract.CharEntry.COLUMN_NAME_MAX_WOUNDS, ((EditText) findViewById(R.id.woundsEdit)).getText().toString());
        values.put(CharContract.CharEntry.COLUMN_NAME_STRAIN, "0");
        values.put(CharContract.CharEntry.COLUMN_NAME_MAX_STRAIN, ((EditText) findViewById(R.id.strainEdit)).getText().toString());
        values.put(CharContract.CharEntry.COLUMN_NAME_MELEE_DEFENSE, ((EditText) findViewById(R.id.meleeDefEdit)).getText().toString());
        values.put(CharContract.CharEntry.COLUMN_NAME_RANGED_DEFENSE, ((EditText) findViewById(R.id.rangeDefEdit)).getText().toString());
        values.put(CharContract.CharEntry.COLUMN_NAME_ENCUM, "0");
        values.put(CharContract.CharEntry.COLUMN_NAME_MAX_ENCUM, Integer.valueOf(((EditText) findViewById(R.id.brawnEdit)).getText().toString()) + 5 + "");
        values.put(CharContract.CharEntry.COLUMN_NAME_XP, ((EditText) findViewById(R.id.xpEdit)).getText().toString());
        values.put(CharContract.CharEntry.COLUMN_NAME_TOTAL_XP, totalXp + "");

        db.update(
                CharContract.CharEntry.TABLE_NAME,
                values,
                "_id=\"" + rowId + "\"",
                null );

        db.close();

        Intent intent = new Intent(getBaseContext(), StatsListActivity.class);
        intent.putExtra(ROW_ID, rowId);
        startActivity(intent);
    }
}
