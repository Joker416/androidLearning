package com.example.punchapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
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
//                Toast.makeText(loginActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(loginActivity.this, registerActivity.class);
                startActivity(intent);
            }
        });

        CustomToolBar toolBar = findViewById(R.id.toolbar);
        toolBar.setTitle("Study");
//        toolBar.setRightText("Hello");
//        toolBar.hideRight();


        //处理登录按钮事件
        Button loginButton = findViewById(R.id.loginButton);
        final RadioButton teacherBtn = findViewById(R.id.teacherBtn);
        final RadioButton studentBtn = findViewById(R.id.studentBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teacherBtn.isChecked()){
                    Toast.makeText(loginActivity.this, "teacherActivity", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(loginActivity.this, teacherActivity.class);
                    startActivity(intent);
                }
                else if(studentBtn.isChecked()){
                    Toast.makeText(loginActivity.this, "student", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(loginActivity.this, studentActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(loginActivity.this, "请选择您的身份", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
