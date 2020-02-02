package com.example.broadcasttest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private IntentFilter intentFilter;

    private AnotherBroadcastReceiver anotherBroadcastReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter("com.example.boardcasttest.MY_BROADCAST");
        intentFilter.setPriority(666);
        anotherBroadcastReceiver = new AnotherBroadcastReceiver();
        registerReceiver(anotherBroadcastReceiver, intentFilter);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unregisterReceiver(anotherBroadcastReceiver);
    }



    class AnotherBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            Toast.makeText(context, "received by AnotherBroadcastReceiver", Toast.LENGTH_SHORT).show();
        }
    }
}
