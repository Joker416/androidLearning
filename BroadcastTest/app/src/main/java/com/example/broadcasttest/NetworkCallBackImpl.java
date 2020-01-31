package com.example.broadcasttest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;
import android.widget.Toast;

public class NetworkCallBackImpl extends ConnectivityManager.NetworkCallback {

    private static final String TAG="NetworkCallBackImpl";

    @Override
    public void onAvailable(Network network){
        super.onAvailable(network);
        Log.d(TAG, "onAvailable: 网络已连接");
//        Toast.makeText(, "")
    }

    @Override
    public void onLost(Network network){
        super.onLost(network);
        Log.d(TAG, "onLost: 网络已断开");
    }

    @Override
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities){
        super.onCapabilitiesChanged(network, networkCapabilities);
        if(networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)){
            if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
                Log.d(TAG, "Wifi: wifi网络连接");
            else
                Log.d(TAG, "流量已连接");
        }
    }
}
