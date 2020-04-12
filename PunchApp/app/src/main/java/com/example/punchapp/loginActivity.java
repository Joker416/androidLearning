package com.example.punchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView test = findViewById(R.id.registerTextView);
        test.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(loginActivity.this, "Registered", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
