package com.enlume.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends Activity {
	TextView textView=null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.nextsub);
    	setTitle(this.getLocalClassName());
        textView=(TextView)findViewById(R.id.text);
        textView.setText("click the button for squasre");
        Log.d("sample", "test");
		
        	Button button = (Button) findViewById(R.id.but2);
        	 button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v){
				Bundle recievedBundle=getIntent().getExtras();
				int value=recievedBundle.getInt("value");
				int square=value+value;
				Intent i = new Intent();
				Bundle resultBundle = new Bundle();
				resultBundle.putString("square",""+square);
				Log.d("result=",""+square);
				i.putExtras(resultBundle);
				
				setResult(Activity.RESULT_OK,i);
				finish();
				
				}
		});
	}
}