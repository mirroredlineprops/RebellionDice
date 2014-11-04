package com.mirroredlineprops.alex.rebelliondice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mirroredlineprops.alex.rebelliondice.adapters.ExpandableListAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ExpandableListView;

public class ExpandableListActivity extends Activity {

    List<String> groupList;
    //List<String> childList;
    Map<String, List<String>> resultsCollection;
    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String message = intent.getStringExtra(StatsListActivity.EXTRA_MESSAGE);
        OddsAnalysis oa = new OddsAnalysis();
        List<String> results = oa.runOdds(message);
        setContentView(R.layout.activity_expandable_list);

        createGroupList(results);
        createCollection(results);

        expListView = (ExpandableListView) findViewById(R.id.odds_View);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, resultsCollection);
        expListView.setAdapter(expListAdapter);

        //setGroupIndicatorToRight();

        /*
        expListView.setOnChildClickListener(new OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                final String selected = (String) expListAdapter.getChild(
                        groupPosition, childPosition);
                Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG)
                        .show();

                return true;
            }
        });
        */
    }

    private void createGroupList(List<String> results) {
        groupList = new ArrayList<String>();
        groupList.add(results.get(0));
        groupList.add(results.get(1));
    }

    private void createCollection(List<String> results) {

        resultsCollection = new LinkedHashMap<String, List<String>>();
        List<String> successList = new ArrayList<String>();
        List<String> failureList = new ArrayList<String>();
        for (String result : results.subList(2, results.size())) {
            if (result.startsWith("Success")) {
                successList.add(result);
            }
            else {
                failureList.add(result);
            }
        }
        resultsCollection.put(results.get(0), successList);
        resultsCollection.put(results.get(1), failureList);
    }

    /*
    private void setGroupIndicatorToRight() {
        /* Get the screen width /
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;

        expListView.setIndicatorBounds(width - getDipsFromPixel(35), width
                - getDipsFromPixel(5));
    }
    */

    /*
    // Convert pixel to dip
    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.expandable_list, menu);
        return true;
    }
}
