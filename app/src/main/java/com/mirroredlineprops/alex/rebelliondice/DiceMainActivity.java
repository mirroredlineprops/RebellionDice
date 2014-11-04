package com.mirroredlineprops.alex.rebelliondice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mirroredlineprops.alex.rebelliondice.adapters.RefAdapter;


public class DiceMainActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.mirroredlineprops.alex.rebelliondice.MESSAGE";
    TextView editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odds__analysis);
        editText = (TextView) findViewById(R.id.edit_message);

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

    /** Called when the user clicks the Send button */
    public void calculateOdds(View view) {
        if (editText.getText().length()==0) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Please set at least one die");
            AlertDialog dialog = alertDialogBuilder.create();
            dialog.show();
        }
        else{
            Intent intent = new Intent(this, ExpandableListActivity.class);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }

    public void rollDice(View view) {
        if (editText.getText().length()==0) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Please set at least one die");
            AlertDialog dialog = alertDialogBuilder.create();
            dialog.show();
        }
        else {
            Intent intent = new Intent(this, DiceRollActivity.class);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }

    public void addGreen(View view) {
        if (editText.getText().length() == 0) {
            editText.setText("Green");
        }
        else {
            editText.setText(editText.getText() + ", Green");
        }
    }

    public void addYellow(View view) {
        if (editText.getText().length() == 0) {
            editText.setText("Yellow");
        }
        else {
            editText.setText(editText.getText() + ", Yellow");
        }
    }

    public void addWhite(View view) {
        if (editText.getText().length() == 0) {
            editText.setText("White");
        }
        else {
            editText.setText(editText.getText() + ", White");
        }
    }

    public void addPurple(View view) {
        if (editText.getText().length() == 0) {
            editText.setText("Purple");
        }
        else {
            editText.setText(editText.getText() + ", Purple");
        }
    }

    public void addRed(View view) {
        if (editText.getText().length() == 0) {
            editText.setText("Red");
        }
        else {
            editText.setText(editText.getText() + ", Red");
        }
    }

    public void addBlack(View view) {
        if (editText.getText().length() == 0) {
            editText.setText("Black");
        }
        else {
            editText.setText(editText.getText() + ", Black");
        }
    }

    public void undoOnce(View view) {
        String text = editText.getText().toString();
        String dice[] = text.split(", ");
        text = "";
        for(int i=0;i<dice.length -1;i++){
            if( i > 0 ){
                text += ", ";
            }
            text += dice[i];
        }
        editText.setText(text);
    }

    public void undoAll(View view) {
        editText.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dice_main, menu);
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
}
