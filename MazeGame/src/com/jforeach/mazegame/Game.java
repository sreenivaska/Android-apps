package com.jforeach.mazegame;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class Game extends Activity {
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		Maze maze = (Maze)extras.get("maze");
		
		GameView gameView = new GameView(this,maze);
		
		LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
		
	    LinearLayout completeView = new LinearLayout(this);
	    completeView.setLayoutParams(layoutParams);
	    completeView.setOrientation(LinearLayout.HORIZONTAL);
	    
	    View gameControlsView = findViewById(R.id.gameControls); //getLayoutInflater().inflate(R.layout.game_controls, null);
	    
	    

	    completeView.addView(gameView);
	    completeView.addView(gameControlsView);
	    
	    setContentView(completeView, layoutParams);
		
		//setContentView(gameView);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}
}
