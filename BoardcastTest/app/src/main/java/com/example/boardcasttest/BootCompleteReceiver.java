package com.example.boardcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BootCompleteReceiver extends BroadcastReceiver {

    private static final String TAG = "BootCompleteReceiver";
    
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Log.d(TAG, "onReceive: boot complete");
        Toast.makeText(context, "Boot Complete", Toast.LENGTH_SHORT).show();
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
