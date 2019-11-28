package com.example.fragmentbestpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class NewsContentActivity extends AppCompatActivity {


    public static void actionStart(Context context, String newsTitle, String newsContent){
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("newsTitle", newsTitle);
        intent.putExtra("newsContent", newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        String newsTitle = getIntent().getStringExtra("newsTitle");
        String newsContent = getIntent().getStringExtra("newsContent");
        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.new_content_fragment);
        newsContentFragment.refresh(newsTitle, newsContent);
    }
}
