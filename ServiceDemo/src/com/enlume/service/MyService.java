package com.enlume.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

	MediaPlayer player;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, "MyService Created", Toast.LENGTH_SHORT).show();
		player = MediaPlayer.create(this, R.raw.why_this_kolaveri);
		player.setLooping(false);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "MyService Startedcommand", Toast.LENGTH_SHORT).show();
		player.start();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		player.stop();
	}
	
}
