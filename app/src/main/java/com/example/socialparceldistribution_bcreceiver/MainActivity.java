package com.example.socialparceldistribution_bcreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    parcelReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "MainActivityParcelReceiver", Toast.LENGTH_LONG).show();


        broadcastReceiver=new parcelReceiver();

    }
   @Override
   protected void onResume(){
        super.onResume();
//       IntentFilter filter= new IntentFilter();
//       filter.addAction("YBandSHU.A_CUSTOM_INTENT");
//       registerReceiver(broadcastReceiver,filter);
   }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
