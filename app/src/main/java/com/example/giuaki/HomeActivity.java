package com.example.giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private LinearLayout profile;
    private LinearLayout listview;
    private TextView txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        txtUsername = (TextView) findViewById(R.id.txtUsername);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String username = extras.getString("username");
            txtUsername.setText(username);
            //The key argument here must match that used in the other activity
        }

        profile = (LinearLayout) findViewById(R.id.profile_button);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profile = new Intent(HomeActivity.this, ProfileActivity.class);
                profile.putExtra("username", txtUsername.getText().toString());
                HomeActivity.this.startActivity(profile);
            }
        });

        listview = (LinearLayout) findViewById(R.id.list_view_button);

        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listview = new Intent(HomeActivity.this, ListViewActivity.class);
                HomeActivity.this.startActivity(listview);
            }
        });
    }
}