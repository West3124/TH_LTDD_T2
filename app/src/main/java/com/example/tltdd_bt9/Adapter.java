package com.example.tltdd_bt9;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private String[] phoneNames;
    private String[] phoneNumbers;

    public Adapter(Activity activity, String[] phoneNames, String[] phoneNumbers) {
        this.activity = activity;
        this.phoneNames = phoneNames;
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public int getCount() {
        return phoneNumbers.length;
    }

    @Override
    public Object getItem(int i) {
        return phoneNumbers[i];
    }

    public Object getPhoneName(int i){
        return phoneNames[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.item_name, null);
        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        tvName.setText(phoneNames[i]);
        TextView  tvDescription = (TextView) view.findViewById(R.id.tvPhoneNumber);
        tvDescription.setText(phoneNumbers[i]);
        ImageView image =(ImageView) view.findViewById(R.id.avata);
        image.setImageResource(R.drawable.ic_baseline_account_circle_24);
        return view;
    }
}
