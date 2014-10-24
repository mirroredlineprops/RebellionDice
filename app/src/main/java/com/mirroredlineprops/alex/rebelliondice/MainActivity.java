package com.mirroredlineprops.alex.rebelliondice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;


public class MainActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.mirroredlineprops.alex.rebelliondice.MESSAGE";
    TextView editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odds__analysis);
        editText = (TextView) findViewById(R.id.edit_message);
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
            Intent intent = new Intent(this, DiceRoll.class);
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
        getMenuInflater().inflate(R.menu.odds__analysis, menu);
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
