package com.example.shubham.assignment_dipper;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by shubham on 7/4/16.
 */
public class MyGcmListenerService extends GcmListenerService {
    @Override
    public void onMessageReceived(String from , Bundle data){
        String notification = data.getString("message");
        Log.i("Response_GCM","New Notification");
        Log.d("Notification:",notification);
        Log.d("From:",from);
    }
}
