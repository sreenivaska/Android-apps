package com.enlume.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServiceDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button startButton = (Button)findViewById(R.id.start);
        Button stopButton = (Button)findViewById(R.id.stop);
        
        startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// start the service	
				startService(new Intent(ServiceDemoActivity.this, MyService.class));
			}
        });

        stopButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// stop the service			
				stopService(new Intent(ServiceDemoActivity.this, MyService.class));
			}
        });
        
     
    }
}