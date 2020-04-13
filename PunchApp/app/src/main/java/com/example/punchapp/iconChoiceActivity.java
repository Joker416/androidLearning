package com.example.punchapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.clz.view.customtoolbar.CustomToolBar;

import java.util.ArrayList;
import java.util.List;

public class iconChoiceActivity extends AppCompatActivity {

    private List<Icons> iconsList = new ArrayList<>();

    private int[] imageId = {R.drawable.icon1, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4,
            R.drawable.icon5, R.drawable.icon6, R.drawable.icon7, R.drawable.icon8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_choice);
        initIcons();
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();

        //配置标题栏
        CustomToolBar toolBar = findViewById(R.id.toolbar);
        toolBar.setTitle("头像选择");
        toolBar.setLeftOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(iconChoiceActivity.this,"Return", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //设置GridView
        GridView gridView = findViewById(R.id.iconGridView);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageId.length;
            }
            @Override
            public Object getItem(int position) {
                return position;
            }
            @Override
            public long getItemId(int position) {
                return position;
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView;
                if(convertView == null){
                    imageView = new ImageView(iconChoiceActivity.this);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(400);
                    imageView.setMaxWidth(400);
                    imageView.setPadding(10,10,10,10);
                }else{
                    imageView=(ImageView)convertView;
                }
                imageView.setImageResource(imageId[position]);
                return imageView;
            }
        };
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=getIntent();
                intent.putExtra("imageId", imageId[position]);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    private void initIcons(){
        Icons icon1 = new Icons(R.drawable.icon1);
        iconsList.add(icon1);
        Icons icon2 = new Icons(R.drawable.icon2);
        iconsList.add(icon2);
        Icons icon3 = new Icons(R.drawable.icon3);
        iconsList.add(icon3);
        Icons icon4 = new Icons(R.drawable.icon4);
        iconsList.add(icon4);
        Icons icon5 = new Icons(R.drawable.icon5);
        iconsList.add(icon5);
        Icons icon6 = new Icons(R.drawable.icon6);
        iconsList.add(icon6);
        Icons icon7 = new Icons(R.drawable.icon7);
        iconsList.add(icon7);
        Icons icon8 = new Icons(R.drawable.icon8);
        iconsList.add(icon8);
    }
}
