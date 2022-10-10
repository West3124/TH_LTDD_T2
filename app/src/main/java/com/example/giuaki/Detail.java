package com.example.giuaki;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String item = extras.getString("item");
            TextView tv_item = (TextView) findViewById(R.id.tv_name);
            String Sclass = extras.getString("class");
            TextView tv_class = (TextView) findViewById(R.id.tv_class);
            ImageView iv_image = (ImageView) findViewById(R.id.image);
            tv_item.setText(item);
            tv_class.setText("Class: " + Sclass);
            //The key argument here must match that used in the other activity
        }

    }
}
