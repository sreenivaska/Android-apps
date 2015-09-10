package com.enlume.orientation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ManagingScreenOrientationsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);
    	Log.d("StateInfo", "onCreate");
    	}
    	@Override
    	public void onStart() {
    	Log.d("StateInfo", "onStart");
    	super.onStart();
    	}
    	@Override
    	public void onResume() {
    	Log.d("StateInfo", "onResume");
    	super.onResume();
    	}
    	@Override
    	public void onPause() {
    	Log.d("StateInfo", "onPause");
    	super.onPause();
    	}
    	@Override
    	public void onStop() {
    	Log.d("StateInfo", "onStop");
    	super.onStop();
    	}
    	@Override
    	public void onDestroy() {
    	Log.d("StateInfo", "onDestroy");
    	super.onDestroy();
    	}
    	@Override
    	public void onRestart() {
    	Log.d("StateInfo", "onRestart");
    	super.onRestart();
    	}
    	}