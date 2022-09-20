package com.example.tltdd_bt5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private String[] items;

    public Adapter(Activity activity, String[] items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.item, null);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        tvName.setText(items[i]);
        return view;
    }

    public void removeItem(int i) {
        List<String> itemsList = new ArrayList<String>();
        for(int ck= 0;ck<items.length;ck++)
        {
            if(ck == i)
            {
                // No operation here
            }
            else
            {
                itemsList.add(items[ck]);
            }
        }
        items = itemsList.toArray(new String[itemsList .size()]);
    }
}