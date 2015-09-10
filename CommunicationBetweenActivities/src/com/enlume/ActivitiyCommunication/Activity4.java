package com.enlume.ActivitiyCommunication;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity4 extends Activity{
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        TextView view = new TextView(this);
	        view.setText("Activity4 called using Intent Filter");
	        setContentView(view);
	    }
}
