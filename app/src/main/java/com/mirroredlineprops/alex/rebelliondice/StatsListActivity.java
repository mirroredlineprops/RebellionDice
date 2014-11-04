package com.mirroredlineprops.alex.rebelliondice;

import android.app.Activity;
import android.content.Intent;
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

import com.mirroredlineprops.alex.rebelliondice.adapters.StatsListAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class StatsListActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.mirroredlineprops.alex.rebelliondice.MESSAGE";
    List<String> groupList;
    //List<String> childList;
    Map<String, List<String>> resultsCollection;
    ExpandableListView expListView;
    String[] DayOfWeek = {"Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"};
    String selected = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_list);

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
        groupList.add("Hello");
        //groupList.add(results.get(1));
    }

    private void createCollection(List<String> results) {

        resultsCollection = new LinkedHashMap<String, List<String>>();
        List<String> successList = new ArrayList<String>();
        successList.add("World");
        /*
        for (String result : results.subList(2, results.size())) {
            if (result.startsWith("Success")) {
                successList.add(result);
            }
            else {
                failureList.add(result);
            }
        }
        */
        resultsCollection.put("Hello", successList);
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
