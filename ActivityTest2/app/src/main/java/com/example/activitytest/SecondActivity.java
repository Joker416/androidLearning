package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
//        Log.d(TAG, "Task id is " + getTaskId());
        setContentView(R.layout.second_layout);
//        Intent intent = getIntent();
//        String data = intent.getStringExtra("extra_data");
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
//                intent.putExtra("data_return", "Hello ActivityFirst");
//                setResult(RESULT_OK, intent);
//                finish();
            }
        });
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello ActivityFirst");
        setResult(RESULT_OK, intent);
        finish();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
