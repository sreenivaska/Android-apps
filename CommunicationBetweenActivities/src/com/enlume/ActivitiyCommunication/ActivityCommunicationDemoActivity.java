package com.enlume.ActivitiyCommunication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityCommunicationDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 super.onCreate(savedInstanceState);
         setContentView(R.layout.main);
         
        Button button1 = (Button) findViewById(R.id.start);
 		button1.setOnClickListener(new Button.OnClickListener(){
 			public void onClick(View arg0) {
 				Intent intent = new Intent(ActivityCommunicationDemoActivity.this,Activity1.class);
 				startActivity(intent);
 			}
         	
         });
    }
}