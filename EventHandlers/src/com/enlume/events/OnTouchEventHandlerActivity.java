package com.enlume.events;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class OnTouchEventHandlerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.touch);
		FrameLayout main = (FrameLayout) findViewById(R.id.main_view);
	    main.addView(new Ball(this,50,50,25));
	    main.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent e) {
				// TODO Auto-generated method stub
				 float x = e.getX();
					float y = e.getY();
				        FrameLayout flView = (FrameLayout) v;
					flView.addView(new Ball(OnTouchEventHandlerActivity.this, x,y,25));
				return false;
			}
	    
	    });
	}
	
	

}
