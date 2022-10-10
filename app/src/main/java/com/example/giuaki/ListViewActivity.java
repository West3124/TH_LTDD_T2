package com.example.giuaki;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private String[] items = {"SCP-", "SCP-999", "SCP-106", "SCP-173", "SCP-682"};
    private String[] classes = {"Safe", "Safe", "Keter", "Euclid", "Keter"};
    private String[] images = {"@drawable/ic_account_circle_24", "@drawable/ic_account_circle_24", "@drawable/ic_account_circle_24", "@drawable/ic_account_circle_24", "@drawable/ic_account_circle_24"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        Adapter itemsAdapter = new Adapter(this, items, classes, images);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent detail = new Intent(ListViewActivity.this, Detail.class);
            detail.putExtra("item", String.valueOf(itemsAdapter.getItem(i)));
            detail.putExtra("class", String.valueOf(itemsAdapter.getClass(i)));
            detail.putExtra("image", String.valueOf(itemsAdapter.getImage(i)));
            ListViewActivity.this.startActivity(detail);
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