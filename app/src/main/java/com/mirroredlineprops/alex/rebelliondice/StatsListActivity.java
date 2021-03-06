package com.mirroredlineprops.alex.rebelliondice;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.PopupWindow;
import android.widget.Spinner;

import com.mirroredlineprops.alex.rebelliondice.adapters.CardItemData;
import com.mirroredlineprops.alex.rebelliondice.adapters.StatsListAdapter;
import com.mirroredlineprops.alex.rebelliondice.contracts.CharContract;
import com.mirroredlineprops.alex.rebelliondice.dbhelpers.StatsDbHelper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class StatsListActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.mirroredlineprops.alex.rebelliondice.MESSAGE";
    public final static String ROW_ID = "com.mirroredlineprops.alex.rebelliondice.ROW_ID";
    List<String> groupList;
    //List<String> childList;
    Map<String, List<String>> resultsCollection;
    ExpandableListView expListView;
    String[] DayOfWeek = {"Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"};
    String selected = "";
    Long rowId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_list);
        Intent intent = getIntent();
        rowId = intent.getLongExtra(StatsListActivity.ROW_ID, -1);

        createGroupList(null);
        createCollection(null);

        expListView = (ExpandableListView) findViewById(R.id.stats_list);
        final StatsListAdapter expListAdapter = new StatsListAdapter(
                this, groupList, resultsCollection);
        expListView.setAdapter(expListAdapter);

        //setGroupIndicatorToRight();
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                LayoutInflater layoutInflater =
                        (LayoutInflater)getBaseContext()
                                .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.spinner_dialog, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);

                Spinner popupSpinner = (Spinner)popupView.findViewById(R.id.popupspinner);

                ArrayAdapter<String> adapter =
                        new ArrayAdapter<String>(StatsListActivity.this,
                                android.R.layout.simple_spinner_item, DayOfWeek);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                popupSpinner.setAdapter(adapter);
                selected = (String) expListAdapter.getChild(groupPosition, childPosition);
                btnDismiss.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }});
                popupWindow.showAsDropDown(expListView);
                //popupWindow.showAsDropDown(btnOpenPopup, 50, -30);
                return true;
            }
        });
    }

    private void createGroupList(List<String> results) {
        groupList = new ArrayList<String>();
        groupList.add("Character");
        groupList.add("Attributes");
        groupList.add("Stats");
        groupList.add("Skills");
        groupList.add("Weapons");
        groupList.add("Armor and Gear");
        groupList.add("Talents");
        groupList.add("Injuries");
        groupList.add("Background");
        groupList.add("Description");

    }

    private void createCollection(List<String> results) {
        resultsCollection = new LinkedHashMap<String, List<String>>();
        StatsDbHelper stats = new StatsDbHelper(getBaseContext());
        SQLiteDatabase statsDb= stats.getReadableDatabase();
        Cursor c = StatsDbHelper.getCharById(statsDb, rowId);
        if (c.moveToFirst()) {
            List<String> charList = new ArrayList<String>();
            charList.add("Name: " + c.getString(2));
            charList.add("Species: " + c.getString(3));
            charList.add("Career: " + c.getString(4));
            charList.add("Specializations: " + c.getString(5));
            resultsCollection.put("Character", charList);

            List<String> statsList = new ArrayList<String>();
            statsList.add("Soak: " + c.getString(6));
            statsList.add("Wounds: " + c.getString(7) + " / " + c.getString(8));
            statsList.add("Strain: " + c.getString(9) + " / " + c.getString(10));
            statsList.add("Ranged Defense: " + c.getString(14));
            statsList.add("Melee Defense: " + c.getString(13));
            resultsCollection.put("Stats", statsList);

            List<String> attrList = new ArrayList<String>();
            attrList.add("Brawn: " + c.getString(15));
            attrList.add("Agility: " + c.getString(16));
            attrList.add("Intellect: " + c.getString(17));
            attrList.add("Cunning: " + c.getString(18));
            attrList.add("Willpower: " + c.getString(19));
            attrList.add("Presence: " + c.getString(20));
            resultsCollection.put("Attributes", attrList);

            List<String> skillsList = new ArrayList<String>();
            skillsList.add("TODO");
            resultsCollection.put("Skills", skillsList);

            List<String> talentList = new ArrayList<String>();
            talentList.add("TODO");
            resultsCollection.put("Talents", talentList);

            List<String> backgroundList = new ArrayList<String>();
            backgroundList.add("TODO");
            resultsCollection.put("Background", backgroundList);

            List<String> weaponList = new ArrayList<String>();
            weaponList.add("TODO");
            resultsCollection.put("Weapons", weaponList);

            List<String> gearList = new ArrayList<String>();
            gearList.add("TODO");
            gearList.add("Encumbrance: " + c.getString(11) + " / " + c.getString(12));
            gearList.add("XP: " + c.getString(21) + " / " + c.getString(22));
            resultsCollection.put("Armor and Gear", gearList);

            List<String> descList = new ArrayList<String>();
            descList.add("TODO");
            resultsCollection.put("Description", descList);

            List<String> injList = new ArrayList<String>();
            injList.add("TODO");
            resultsCollection.put("Injuries", injList);


        }
        statsDb.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.stats_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_dice:
                openDice();
                return true;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openDice() {
        Intent intent = new Intent(this, DiceMainActivity.class);
        startActivity(intent);
    }
}
