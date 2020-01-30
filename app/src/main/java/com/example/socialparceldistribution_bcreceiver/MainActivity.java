package com.example.socialparceldistribution_bcreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    parcelReceiver t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(
                t=  new parcelReceiver(),
                new IntentFilter(Intent.ACTION_TIME_TICK));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("YBandSHU.A_CUSTOM_INTENT");
        registerReceiver(t,intentFilter);
    }
}
