package com.example.intentservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SortedArrayBroadcastReceiver broadcastReceiver;
    private Button sortButton;
    private TextView infoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoTextView = findViewById(R.id.app_name);

        sortButton = findViewById(R.id.sort_button);
        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SortedArrayIntentService.class);
                startService(intent);
            }
        });
        broadcastReceiver = new SortedArrayBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(SortedArrayIntentService.ACTION_INTENT_SERVICE);
        registerReceiver(broadcastReceiver, intentFilter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

    public class SortedArrayBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String result = intent.getStringExtra(SortedArrayIntentService.KEY);
            infoTextView.setText(result);
        }
    }
}
