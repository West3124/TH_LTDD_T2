package com.example.tltdd_bt9;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            TextView tv_phoneName = (TextView) findViewById(R.id.tv_phoneName);
            String number = extras.getString("number");
            TextView tv_phoneNumber = (TextView) findViewById(R.id.tv_phoneNumber);
            tv_phoneName.setText("Tên: " + name);
            tv_phoneNumber.setText("Số điện thoại: " + number);
            //The key argument here must match that used in the other activity
        }
    }
}
