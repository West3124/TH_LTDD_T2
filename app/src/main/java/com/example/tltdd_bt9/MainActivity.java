package com.example.tltdd_bt9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> phoneNames = new ArrayList<String>();
    private List<String> phoneNumbers = new ArrayList<String>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnGetContactPressed(View v){
        getPhoneContacts();
    }

    private void getPhoneContacts(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS},0);
        }

        ContentResolver contentResolver = getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        Log.i("CONTACT_PROVIDER_DEMO", "TOTAL # of Contacts ::: " + Integer.toString(cursor.getCount()));

        if (cursor.getCount() > 0){
            while (cursor.moveToNext()){
                String contactName = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                phoneNames.add(contactName);

                String contactNumber = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
                phoneNumbers.add(contactNumber);

                Log.i("CONTACT_PROVIDER_DEMO", "Contact Name ::: " + contactName + "Ph# ::: " + contactNumber);
            }

            Adapter itemAdapter = new Adapter(this, phoneNames.toArray(new String[phoneNames .size()]), phoneNumbers.toArray(new String[phoneNumbers.size()]));

            listView = (ListView) findViewById(R.id.lv_items);
            listView.setAdapter(itemAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent detail = new Intent(MainActivity.this, Detail.class);
                    detail.putExtra("number", String.valueOf(itemAdapter.getItem(i)));
                    detail.putExtra("name", String.valueOf(itemAdapter.getPhoneName(i)));
                    MainActivity.this.startActivity(detail);
                }
            });
        }
    }
}