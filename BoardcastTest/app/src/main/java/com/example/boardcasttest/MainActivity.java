package com.example.boardcasttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private IntentFilter intentFilter1;

    private IntentFilter myBroadcastIntentFilter;

    private NetworkChangeReceiver networkChangeReceiver;

    private MyBroadcastReceiver myBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //register first broadcastReceiver
        intentFilter1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter1);
        //register second broadcastReceiver
        myBroadcastIntentFilter = new IntentFilter("com.example.boardcasttest.MY_BROADCAST");
        myBroadcastReceiver = new MyBroadcastReceiver();
        myBroadcastIntentFilter.setPriority(999);
        registerReceiver(myBroadcastReceiver, myBroadcastIntentFilter);


        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent it = new Intent("com.example.boardcasttest.MY_BROADCAST");
                sendOrderedBroadcast(it, null);
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        unregisterReceiver(myBroadcastReceiver);
    }


    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            Toast.makeText(context, "network change", Toast.LENGTH_SHORT).show();
        }
    }

    class MyBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            Toast.makeText(context, "received by myBroadcast", Toast.LENGTH_SHORT).show();
//            abortBroadcast();
        }
    }

    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            Toast.makeText(context, "received by localReceiver", Toast.LENGTH_SHORT).show();
        }
    }
}
