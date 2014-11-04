package com.mirroredlineprops.alex.rebelliondice.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mirroredlineprops.alex.rebelliondice.R;

import java.util.List;
import java.util.Map;

/**
 * Created by AJ on 11/1/2014.
 */
public class StatsListAdapter extends BaseExpandableListAdapter {
    private Activity context;
    private Map<String, List<String>> oddCollections;
    private List<String> odds;

    public StatsListAdapter(Activity context, List<String> odds,
                                 Map<String, List<String>> oddCollections) {
        this.context = context;
        this.oddCollections = oddCollections;
        this.odds = odds;
    }

    public Object getChild(int groupPosition, int childPosition) {
        return oddCollections.get(odds.get(groupPosition)).get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String odd = (String) getChild(groupPosition, childPosition);
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.stats_child_item, null);
        }

        TextView item = (TextView) convertView.findViewById(R.id.statsChild);


        ImageView delete = (ImageView) convertView.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Do you want to remove?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                List<String> child =
                                        oddCollections.get(odds.get(groupPosition));
                                child.remove(childPosition);
                                notifyDataSetChanged();
                            }
                        });
                builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        item.setText(odd);
        return convertView;
    }

    public int getChildrenCount(int groupPosition) {
        return oddCollections.get(odds.get(groupPosition)).size();
    }

    public Object getGroup(int groupPosition) {
        return odds.get(groupPosition);
    }

    public int getGroupCount() {
        return odds.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String oddName = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.stats_group_item,
                    null);
        }
        TextView item = (TextView) convertView.findViewById(R.id.statsGroup);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(oddName);
        return convertView;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
