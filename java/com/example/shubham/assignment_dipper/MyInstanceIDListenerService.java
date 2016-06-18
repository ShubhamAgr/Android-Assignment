package com.example.shubham.assignment_dipper;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by shubham on 7/4/16.
 */
public class MyInstanceIDListenerService extends InstanceIDListenerService {
    @Override
    public void onTokenRefresh(){
        Intent intent = new Intent(this,RegistrationIntentService.class);
        startService(intent);
     }
}
