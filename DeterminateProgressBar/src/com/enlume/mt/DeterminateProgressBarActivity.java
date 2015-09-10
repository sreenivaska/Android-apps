package com.enlume.mt;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;

public class DeterminateProgressBarActivity extends Activity {
	ProgressBar myProgressBar;
	int myProgress = 0;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);

	        myProgressBar=(ProgressBar)findViewById(R.id.progressbar_Horizontal);

	        new Thread(myThread).start();
	}

	private Runnable myThread = new Runnable(){

	        @Override
	        public void run() {
	                // TODO Auto-generated method stub
	                while (myProgress<100){
	                        try{
	                                myHandle.sendMessage(myHandle.obtainMessage());
	                                Log.d("event","in run method myProgress="+myProgress);
	                                Thread.sleep(20000);
	                        }
	                        catch(Throwable t){ }
	                }
	        }

	        Handler myHandle = new Handler(){

	                @Override
	                public void handleMessage(Message msg) {
	                        // TODO Auto-generated method stub
	                        myProgress++;
	                        Log.d("event","in handle method myProgress="+myProgress);
	                        myProgressBar.setProgress(myProgress);
	                }
	        };
	};
}