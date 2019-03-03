package com.example.powerreceiver;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * The Power Receiver app responds to system broadcasts about the power connected state as well
 * as a custom broadcast that is sent when the user pushes the button
 */
public class MainActivity extends AppCompatActivity {

    private CustomReceiver mReceiver = new CustomReceiver();

    private ComponentName mReceiverComponentName;
    private PackageManager mPackageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button broadcastButton = (Button) findViewById(R.id.broadcastButton);

        //Get the PackageManager and ComponentName so you can toggle to broadcast receiver.
        mReceiverComponentName = new ComponentName(this, CustomReceiver.class);
        mPackageManager = getPackageManager();

        //Use LocalBroadcastManager so that the broadcast is not received by other applications.
        LocalBroadcastManager.getInstance(this).registerReceiver
                (mReceiver, new IntentFilter(CustomReceiver.ACTION_CUSTOM_BROADCAST));

        //onClick method for the button
        broadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendCustomBroadcast();
            }
        });

    }

    @Override
    protected void onStart() {
        //Enable the broadcast receiver when the app is visible
        mPackageManager.setComponentEnabledSetting
                (mReceiverComponentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);
        super.onStart();
    }

    @Override
    protected void onStop() {
        //Disable the broadcast receiver when the app is visible
        mPackageManager.setComponentEnabledSetting
                (mReceiverComponentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                        PackageManager.DONT_KILL_APP);
        super.onStop();
    }

    /**
     * Unregister the broadcast receiver when the app is destroyed. This only unregisters it from
     * the custom broadcast, it is still responds to system events defined in AndroidManifest.xml
     */
    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    /**
     * OnClick method that sends the custom broadcast using the LocalBroadcastManager
     */
    private void sendCustomBroadcast() {
        Intent customBroadcastIntent = new Intent(CustomReceiver.ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }
}
