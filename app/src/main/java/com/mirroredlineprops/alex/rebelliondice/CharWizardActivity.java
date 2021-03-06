package com.mirroredlineprops.alex.rebelliondice;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.mirroredlineprops.alex.rebelliondice.adapters.RefAdapter;
import com.mirroredlineprops.alex.rebelliondice.contracts.CharContract.CharEntry;
import com.mirroredlineprops.alex.rebelliondice.dbhelpers.StatsDbHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class CharWizardActivity extends Activity {
    public final static String ROW_ID = "com.mirroredlineprops.alex.rebelliondice.ROW_ID";
    public final static String SPECIES = "com.mirroredlineprops.alex.rebelliondice.SPECIES";
    private long rowId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_wizard);

        Intent intent = getIntent();
        rowId = intent.getLongExtra(CharWizardActivity.ROW_ID, -1);

        RefAdapter refAdapter = new RefAdapter(this);
        refAdapter.createDatabase();
        refAdapter.open();

        List<String> species = refAdapter.getSpecies();
        Map<String, List<String>> careerMap = refAdapter.getCareers();
        refAdapter.close();

        Spinner speciesSpinner = (Spinner) findViewById(R.id.speciesSpinner);
        ArrayAdapter<String> speciesAdapter =
                new ArrayAdapter<String>(CharWizardActivity.this,
                        android.R.layout.simple_spinner_item, species);
        speciesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speciesSpinner.setAdapter(speciesAdapter);
        speciesSpinner.setSelection(4);

        Spinner careerSpinner = (Spinner) findViewById(R.id.careerSpinner);
        ArrayList<String> careerList = new ArrayList<String>(careerMap.keySet());
        Collections.sort(careerList);
        careerList.remove("Universal");
        ArrayAdapter<String> careerAdapter =
                new ArrayAdapter<String>(CharWizardActivity.this,
                        android.R.layout.simple_spinner_item, careerList);
        careerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        careerSpinner.setAdapter(careerAdapter);

        Spinner specialSpinner = (Spinner) findViewById(R.id.specializationSpinner);
        ArrayList<String> specialList = new ArrayList<String>();
        for (List<String> subList:careerMap.values()) {
            for (String spec: subList){
                specialList.add(spec);
            }
        }
        Collections.sort(specialList);
        ArrayAdapter<String> specialAdapter =
                new ArrayAdapter<String>(CharWizardActivity.this,
                        android.R.layout.simple_spinner_item, specialList);
        specialAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        specialSpinner.setAdapter(specialAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.char_wizard, menu);
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
        SQLiteDatabase db= statsDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CharEntry.COLUMN_NAME_ENTRY_ID, 1);
        values.put(CharEntry.COLUMN_NAME_NAME, ((EditText)findViewById(R.id.charNameEdit)).getText().toString());
        values.put(CharEntry.COLUMN_NAME_SPECIES, ((Spinner)findViewById(R.id.speciesSpinner)).getSelectedItem().toString());
        values.put(CharEntry.COLUMN_NAME_CAREER, ((Spinner)findViewById(R.id.careerSpinner)).getSelectedItem().toString());
        values.put(CharEntry.COLUMN_NAME_TREES, ((Spinner)findViewById(R.id.specializationSpinner)).getSelectedItem().toString());

        /*long newRowId = db.insert(
                CharEntry.TABLE_NAME,
                null,
                values );
                */
        db.update(
                CharEntry.TABLE_NAME,
                values,
                "_id=\"" + rowId + "\"",
                null );
        db.close();

        Intent intent = new Intent(getBaseContext(), StatsWizardActivity.class);
        intent.putExtra(ROW_ID, rowId);
        intent.putExtra(SPECIES, ((Spinner)findViewById(R.id.speciesSpinner)).getSelectedItem().toString());
        startActivity(intent);
    }
}
