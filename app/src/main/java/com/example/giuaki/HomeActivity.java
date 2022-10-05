package com.example.giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {
    private LinearLayout profile;
    private LinearLayout listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        profile = (LinearLayout) findViewById(R.id.profile_button);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profile = new Intent(HomeActivity.this, ProfileActivity.class);
                HomeActivity.this.startActivity(profile);
            }
        });

        listview = (LinearLayout) findViewById(R.id.list_view_button);

        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listview = new Intent(HomeActivity.this, ListView.class);
                HomeActivity.this.startActivity(listview);
            }
        });
    }
}