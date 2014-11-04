package com.mirroredlineprops.alex.rebelliondice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mirroredlineprops.alex.rebelliondice.adapters.BaseInflaterAdapter;
import com.mirroredlineprops.alex.rebelliondice.adapters.CardItemData;
import com.mirroredlineprops.alex.rebelliondice.adapters.inflaters.CardInflater;


public class CharCardsActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_cards);

        ListView list = (ListView)findViewById(R.id.card_list_view);

        list.addHeaderView(new View(this));
        list.addFooterView(new View(this));

        BaseInflaterAdapter<CardItemData> adapter = new BaseInflaterAdapter<CardItemData>(new CardInflater());
        CardItemData passThrough = new CardItemData("Click here", "to go to", "blank character");
        adapter.addItem(passThrough, false);
        for (int i = 0; i < 5; i++)
        {
            CardItemData data = new CardItemData("Item " + i + " Line 1", "Item " + i + " Line 2", "Item " + i + " Line 3");
            adapter.addItem(data, false);
        }

        list.setAdapter(adapter);
        AdapterView av = (AdapterView)findViewById(R.id.card_list_view);
        av.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CharCardsActivity.this, StatsListActivity.class);
                startActivity(intent);
            }
        });

        //StatsDbHelper statsDbHelper = new StatsDbHelper(getBaseContext());
        //SQLiteDatabase db; //= statsDbHelper.getWritableDatabase();
        /*
        ContentValues values = new ContentValues();
        values.put(WeaponEntry.COLUMN_NAME_ENTRY_ID, 1);
        values.put(WeaponEntry.COLUMN_NAME_NAME, "Test_Name");
        values.put(WeaponEntry.COLUMN_NAME_MODEL, "Test_Model");

        long newRowId;
        newRowId = db.insert(
                WeaponEntry.TABLE_NAME,
                null,
                values );

        db.close();
        */

        /*
        db = statsDbHelper.getReadableDatabase();
        String[] projection = {
                WeaponContract.WeaponEntry._ID,
                WeaponContract.WeaponEntry.COLUMN_NAME_NAME,
                WeaponContract.WeaponEntry.COLUMN_NAME_MODEL
        };

        String sortOrder = WeaponContract.WeaponEntry.COLUMN_NAME_ENTRY_ID + " DESC";
        // Define 'where' part of query.
        String selection = WeaponContract.WeaponEntry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
        // Specify arguments in placeholder order.
        int rowId = 1;
        String[] selectionArgs = { String.valueOf(rowId) };

        Cursor c = db.query(
                WeaponContract.WeaponEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        c.moveToFirst();
        long itemId = c.getLong( c.getColumnIndexOrThrow(WeaponContract.WeaponEntry._ID));
        String name = c.getString(1);
        String model = c.getString(2);

        Log.d("D", itemId + "");
        Log.d("E", name + "");
        Log.d("F", model + "");

        db.close();

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.char_cards, menu);
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
