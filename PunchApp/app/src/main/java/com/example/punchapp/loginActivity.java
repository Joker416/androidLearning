package com.example.punchapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.clz.view.customtoolbar.CustomToolBar;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        TextView registerText = findViewById(R.id.registerTextView);
        registerText.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(loginActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(loginActivity.this, registerActivity.class);
                startActivity(intent);
            }
        });

        CustomToolBar toolBar = findViewById(R.id.toolbar);
//        toolBar.setTitle("Study Happily");
        toolBar.setRightText("Hello");
        toolBar.hideRight();

    }
}
