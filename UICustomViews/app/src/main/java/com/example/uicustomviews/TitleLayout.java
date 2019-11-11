package com.example.uicustomviews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);

        Button titleBack = findViewById(R.id.button_back);
        Button titleOption = findViewById(R.id.button_options);
        titleBack.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                ((Activity)getContext()).finish(); //getContext返回当前View运行在哪个Activity Context中
            }
        });

        titleOption.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getContext(), "You click the option button", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
