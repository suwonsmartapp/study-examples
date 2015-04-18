
package com.suwonsmartapp.studyexam.broadcast;

import com.suwonsmartapp.studyexam.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class BroadcastActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        // Local 리시버 - Activity 가 살아있는 동안에만 동작 하는 리시버
        // MyReceiver receiver = new MyReceiver();
        //
        // IntentFilter intentFilter = new IntentFilter();
        // intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
        // intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        //
        // registerReceiver(receiver, intentFilter);

        findViewById(R.id.btn_send_broadcast).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent("com.suwonsmartapp.hello.TestBroadcast");
        sendBroadcast(intent);
    }
}
