package com.example.activitytest;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
