package com.example.tltdd_bt5;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"Bún", "Cháo", "Phở", "Cơm"};

        Adapter itemsAdapter = new Adapter(this, items);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent detail = new Intent(MainActivity.this, Detail.class);
            detail.putExtra("key", String.valueOf(itemsAdapter.getItem(i)));
            MainActivity.this.startActivity(detail);
        });

       listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
           AlertDialog.Builder adb = new AlertDialog.Builder(adapterView.getContext());
           //adb.setView(Main.this);
           adb.setTitle("Bạn có chắc muốn xóa " + items[i] + "?");
           adb.setIcon(android.R.drawable.ic_dialog_alert);
           adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int which) {
                   itemsAdapter.removeItem(i);
                   listView.setAdapter(itemsAdapter);
                   Toast.makeText(getApplicationContext(), "Đã xóa thành công!", Toast.LENGTH_LONG).show();

               } });

           adb.setNegativeButton("No", (dialog, which) -> {
               //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
               //finish();
           });

           AlertDialog alertDialog = adb.create();
           alertDialog.show();
           return true;
       });

    }
}