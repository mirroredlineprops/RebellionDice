package com.mirroredlineprops.alex.rebelliondice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.mirroredlineprops.alex.rebelliondice.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class DiceRoll extends Activity {

    List<String> groupList;
    String message;
    OddsAnalysis oddsAnalysis;
    Map<String, List<String>> resultsCollection;
    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        oddsAnalysis = new OddsAnalysis();
        resultsCollection = new LinkedHashMap<String, List<String>>();
        groupList = new ArrayList<String>();

        addRoll();

    }

    private void createGroupList(List<String> results) {
        groupList.add(results.get(0));
    }

    private void createCollection(List<String> results, String dice[]) {

        List<String> rollList = new ArrayList<String>();
        int count = 0;
        for (String result : results.subList(1, results.size())) {
            rollList.add(dice[count] + ": " + result);
            count++;
        }
        resultsCollection.put(results.get(0), rollList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.expandable_list, menu);
        return true;
    }

    public void rerollDice(View view) {
        addRoll();
    }

    public void addRoll() {
        List<String> results = oddsAnalysis.rollDice(message);
        String dice[] = message.split(", ");
        setContentView(R.layout.activity_expandable_dice_roll);

        createGroupList(results);
        createCollection(results, dice);

        expListView = (ExpandableListView) findViewById(R.id.roll_View);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, resultsCollection);
        expListView.setAdapter(expListAdapter);
    }

}
