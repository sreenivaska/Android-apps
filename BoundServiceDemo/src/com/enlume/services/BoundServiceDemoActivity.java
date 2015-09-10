package com.enlume.services;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BoundServiceDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.doBindService();
        Button startButton = (Button)findViewById(R.id.start);
        Button stopButton = (Button)findViewById(R.id.stop);
        Button pauseButton=(Button)findViewById(R.id.pause);
        Button resumeButton=(Button)findViewById(R.id.resume);
        
        startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// start the service	
				Intent music = new Intent(BoundServiceDemoActivity.this,MusicService.class);
				startService(music);
			}
        });

        stopButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// stop the service			
				mServ.stopMusic();
			}
        });
        pauseButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// stop the service			
				mServ.pauseMusic();
				
			}
        });
        resumeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// stop the service			
				mServ.resumeMusic();
			}
        });
    }
    private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon =new ServiceConnection(){

    	public void onServiceConnected(ComponentName name, IBinder
         binder) {
    	mServ = ((MusicService.ServiceBinder)binder).getService();
    	 Toast.makeText(BoundServiceDemoActivity.this, "Service Connected",
                 Toast.LENGTH_SHORT).show();
    	}

    	public void onServiceDisconnected(ComponentName name) {
    		mServ = null;
    		 Toast.makeText(BoundServiceDemoActivity.this, "Service Disconnected",
                     Toast.LENGTH_SHORT).show();
    	}
    	};

    	void doBindService(){
     		bindService(new Intent(this,MusicService.class),
    				Scon,Context.BIND_AUTO_CREATE);
    		mIsBound = true;
    	}

    	void doUnbindService()
    	{
    		if(mIsBound)
    		{
    			unbindService(Scon);
          		mIsBound = false;
    		}
    	}
}