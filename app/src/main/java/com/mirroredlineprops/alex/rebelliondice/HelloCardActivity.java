package com.mirroredlineprops.alex.rebelliondice;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mirroredlineprops.alex.rebelliondice.adapters.RefAdapter;
import com.mirroredlineprops.alex.rebelliondice.contracts.WeaponContract.*;
import com.mirroredlineprops.alex.rebelliondice.dbhelpers.StatsDbHelper;

public class HelloCardActivity extends Activity
{
	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hello_card);

		findViewById(R.id.card).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Intent intent = new Intent(HelloCardActivity.this, HelloCardListActivity.class);
				startActivity(intent);
			}
		});

        StatsDbHelper statsDbHelper = new StatsDbHelper(getBaseContext());
        SQLiteDatabase db; //= statsDbHelper.getWritableDatabase();
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
        db = statsDbHelper.getReadableDatabase();
        String[] projection = {
                WeaponEntry._ID,
                WeaponEntry.COLUMN_NAME_NAME,
                WeaponEntry.COLUMN_NAME_MODEL
        };

        String sortOrder = WeaponEntry.COLUMN_NAME_ENTRY_ID + " DESC";
        // Define 'where' part of query.
        String selection = WeaponEntry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
        // Specify arguments in placeholder order.
        int rowId = 1;
        String[] selectionArgs = { String.valueOf(rowId) };

        Cursor c = db.query(
                WeaponEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        c.moveToFirst();
        long itemId = c.getLong( c.getColumnIndexOrThrow(WeaponEntry._ID));
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
	}
}
