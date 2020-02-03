package com.example.broadcasttest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private IntentFilter intentFilter1;

    private AnotherBroadcastReceiver anotherBroadcastReceiver;

    private IntentFilter intentFilter_local;

    private LocalBroadcastReceiver localBroadcastReceiver;

    private LocalBroadcastManager localBroadcastManager;

    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent("com.example.broadcasttest2.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
            }
        });

        intentFilter1 = new IntentFilter("com.example.boardcasttest.MY_BROADCAST");
        intentFilter1.setPriority(666);
        anotherBroadcastReceiver = new AnotherBroadcastReceiver();
        registerReceiver(anotherBroadcastReceiver, intentFilter1);

        intentFilter_local = new IntentFilter("com.example.broadcasttest2.LOCAL_BROADCAST");
        localBroadcastReceiver = new LocalBroadcastReceiver();
        localBroadcastManager.registerReceiver(localBroadcastReceiver, intentFilter_local);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unregisterReceiver(anotherBroadcastReceiver);
        unregisterReceiver(localBroadcastReceiver);
    }



    class AnotherBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            Toast.makeText(context, "received by AnotherBroadcastReceiver", Toast.LENGTH_SHORT).show();
        }
    }

    class LocalBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            Toast.makeText(context, "received by localBroadcastReceiver", Toast.LENGTH_SHORT).show();
        }
    }
}
