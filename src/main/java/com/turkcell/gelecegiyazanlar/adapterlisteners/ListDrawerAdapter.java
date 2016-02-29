package com.turkcell.gelecegiyazanlar.adapterlisteners;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.models.DrawerItems;

import java.util.ArrayList;

/**
 * Created by asus on 27.8.2015.
 */
public class ListDrawerAdapter extends BaseAdapter {

    ArrayList<DrawerItems> drawerItemList;

    public ListDrawerAdapter(ArrayList<DrawerItems> drawerItemList) {
        this.drawerItemList = drawerItemList;
    }

    @Override
    public int getCount() {
        return drawerItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return drawerItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.drawer_list_item, parent, false);
        }

        DrawerItems drawerItems = drawerItemList.get(position);
        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        TextView textView = (TextView) convertView.findViewById(R.id.drawerText);

        icon.setImageResource(drawerItems.getIcon());
        textView.setText(drawerItems.getText());

        return convertView;
    }
}
