package com.turkcell.gelecegiyazanlar.adapterlisteners;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.activities.EgitimIcerikActivity;
import com.turkcell.gelecegiyazanlar.models.Egitim;

import java.util.ArrayList;

public class MyExpandableAdapter extends BaseExpandableListAdapter {

    private Activity activity;
    private ArrayList<Object> childtems, childIdItems;
    private LayoutInflater inflater;
    private ArrayList<String> parentItems, child, nodeIDGroup, childId;
    private int lastPosition = -1;

    public MyExpandableAdapter(ArrayList<String> parents, ArrayList<Object> childern, ArrayList<Object> childIdItems, ArrayList<String> nodeIDParent) {
        this.parentItems = parents;
        this.childtems = childern;
        this.nodeIDGroup = nodeIDParent;
        this.childIdItems = childIdItems;
    }

    public void setInflater(LayoutInflater inflater, Activity activity) {
        this.inflater = inflater;
        this.activity = activity;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        child = (ArrayList<String>) childtems.get(groupPosition);
        childId = (ArrayList<String>) childIdItems.get(groupPosition);

        final TextView textView;


        if (convertView == null) {
            convertView = inflater.inflate(R.layout.kategori_child_item, null);
        }

        textView = (TextView) convertView.findViewById(R.id.tvChildParent);
        final TextView nodeChild = (TextView) convertView.findViewById(R.id.nodeID);
        textView.setText(child.get(childPosition));
        nodeChild.setText(childId.get(childPosition));
        Log.d("ifade", childId.get(childPosition) + " " + child.get(childPosition));


        convertView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, EgitimIcerikActivity.class);
                i.putExtra(Egitim.NODE_ID_EGITIM, nodeChild.getText().toString());
                i.putExtra(Egitim.NODE_TITLE, textView.getText().toString());
                activity.startActivity(i);
            }
        });

        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, EgitimIcerikActivity.class);
                i.putExtra(Egitim.NODE_ID_EGITIM, nodeChild.getText().toString());
                i.putExtra(Egitim.NODE_TITLE, textView.getText().toString());
                activity.startActivity(i);
            }
        });


        return convertView;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.kategori_parent_item, null);
        }

        ((CheckedTextView) convertView.findViewById(R.id.tvChildParent)).setText(parentItems.get(groupPosition));
        ((CheckedTextView) convertView.findViewById(R.id.tvChildParent)).setChecked(isExpanded);
        final TextView id = ((TextView) convertView.findViewById(R.id.id));
        id.setText(nodeIDGroup.get(groupPosition));


        return convertView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ((ArrayList<String>) childtems.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public int getGroupCount() {
        return parentItems.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
