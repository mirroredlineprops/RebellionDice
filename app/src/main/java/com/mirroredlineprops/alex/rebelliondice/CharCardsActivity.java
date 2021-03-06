package com.mirroredlineprops.alex.rebelliondice;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.mirroredlineprops.alex.rebelliondice.adapters.BaseInflaterAdapter;
import com.mirroredlineprops.alex.rebelliondice.adapters.CardItemData;
import com.mirroredlineprops.alex.rebelliondice.adapters.inflaters.CardInflater;
import com.mirroredlineprops.alex.rebelliondice.contracts.CharContract.CharEntry;
import com.mirroredlineprops.alex.rebelliondice.dbhelpers.StatsDbHelper;


public class CharCardsActivity extends Activity {
    public final static String ROW_ID = "com.mirroredlineprops.alex.rebelliondice.ROW_ID";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_cards);

        findViewById(R.id.diceCard).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CharCardsActivity.this, DiceMainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.newCharCard).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                StatsDbHelper statsDbHelper = new StatsDbHelper(getBaseContext());
                SQLiteDatabase db= statsDbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(CharEntry.COLUMN_NAME_ENTRY_ID, 1);
                long newRowId;
                newRowId = db.insert(
                        CharEntry.TABLE_NAME,
                        null,
                        values );

                db.close();

                Intent intent = new Intent(CharCardsActivity.this, CharWizardActivity.class);
                intent.putExtra(ROW_ID, newRowId);
                startActivity(intent);
            }
        });

        updateCards();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.char_cards, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateCards() {
        ListView list = (ListView)findViewById(R.id.card_list_view);

        list.addHeaderView(new View(this));
        list.addFooterView(new View(this));

        BaseInflaterAdapter<CardItemData> adapter = new BaseInflaterAdapter<CardItemData>(new CardInflater());
        CardItemData passThrough = new CardItemData("Click here", "to go to", "blank character");
        adapter.addItem(passThrough, false);
        StatsDbHelper stats = new StatsDbHelper(getBaseContext());
        SQLiteDatabase statsDb= stats.getReadableDatabase();
        Cursor c = StatsDbHelper.getCharNames(statsDb);

        if(c.moveToFirst()) {
            do {
                long itemId = c.getLong( c.getColumnIndexOrThrow(CharEntry._ID));
                String name = c.getString(1);
                CardItemData data = new CardItemData("Id " + itemId, "Name " + name, "");
                adapter.addItem(data, false);
            }
            while(c.moveToNext());

            statsDb.close();


        }

        list.setAdapter(adapter);
        AdapterView av = (AdapterView)findViewById(R.id.card_list_view);
        av.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CharCardsActivity.this, StatsListActivity.class);
                intent.putExtra(CharCardsActivity.ROW_ID, id);
                startActivity(intent);
            }
        });
        /*
        StatsDbHelper statsDbHelper = new StatsDbHelper(getBaseContext());
        SQLiteDatabase db= statsDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CharEntry.COLUMN_NAME_ENTRY_ID, 1);
        values.put(CharEntry.COLUMN_NAME_NAME, "Test_Name");

        long newRowId;
        newRowId = db.insert(
                CharEntry.TABLE_NAME,
                null,
                values );

        db.close();
        */
        /*

        RefAdapter refAdapter = new RefAdapter(this);
        refAdapter.createDatabase();
        refAdapter.open();

        Cursor refData = refAdapter.getSpecies();
        Log.d("HI", "HELLO");
        refData.moveToFirst();
        do {
            Log.d("DATA", "" + refData.getString(1));
        }
        while (refData.moveToNext());

        refAdapter.close();
        */
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            updateCards();
        }
    }

}
