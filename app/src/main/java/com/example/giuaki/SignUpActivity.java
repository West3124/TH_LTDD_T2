package com.example.giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {
    private Button signUp;
    private TextView signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        signUp = (Button) findViewById(R.id.sign_up_button);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(SignUpActivity.this, HomeActivity.class);
                EditText username = (EditText) findViewById(R.id.edtUsername);
                home.putExtra("username", username.getText().toString().trim());
                SignUpActivity.this.startActivity(home);
            }
        });

        signIn = (TextView) findViewById(R.id.sign_in_link);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInPage = new Intent(SignUpActivity.this, SignInActivity.class);
                SignUpActivity.this.startActivity(signInPage);
            }
        });
    }
}