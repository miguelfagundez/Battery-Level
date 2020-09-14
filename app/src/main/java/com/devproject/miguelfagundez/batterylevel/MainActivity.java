package com.devproject.miguelfagundez.batterylevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Views
    private ImageView imageView;
    private TextView textView;
    private Button button;

    // Receiver
    private BroadcastReceiver broadcastBatteryLevels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // -------------------------
        setupViews();
        setupBroadcastReceiver();
        // -------------------------
    }

    private void setupViews() {
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.btnCheck);
    }

    private void setupBroadcastReceiver() {
        broadcastBatteryLevels = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //-------------------------------------
                // Do something with this data :)
                //-------------------------------------
                Integer batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                if (batteryLevel > 90){
                    // Battery is full
                    imageView.setImageResource(R.drawable.full);
                    textView.setText("The battery level is " + batteryLevel.toString() + " (Full)");
                }else{
                    if (batteryLevel > 60){
                        // Battery is Ok
                        imageView.setImageResource(R.drawable.medium);
                        textView.setText("The battery level is " + batteryLevel.toString() + " (Medium)");
                    }else{
                        if (batteryLevel > 30){
                            // Battery is Low
                            imageView.setImageResource(R.drawable.medium_low);
                            textView.setText("The battery level is " + batteryLevel.toString() + " (Medium Low)");
                        }else{
                            // Battery is Critical
                            imageView.setImageResource(R.drawable.low);
                            textView.setText("The battery level is " + batteryLevel.toString() + " (Low)");
                        }
                    }
                }
            }
        };

        // Set an action for battery has changed
        // I need to register my receiver
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadcastBatteryLevels, intentFilter);
    }
}