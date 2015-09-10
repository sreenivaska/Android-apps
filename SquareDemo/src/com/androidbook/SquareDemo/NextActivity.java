package com.androidbook.SquareDemo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NextActivity extends Activity {
   
	TextView textView=null;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextsub);
        textView=(TextView)findViewById(R.id.text);
        textView.setText("click the button for squasre");
		
        	Button button = (Button) findViewById(R.id.but2);
        	 button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v){
				Bundle recievedBundle=getIntent().getExtras();
				int value=recievedBundle.getInt("value");
				int square=value*value;
				Intent i = new Intent();
				Bundle resultBundle = new Bundle();
				resultBundle.putString("square",""+square);
				i.putExtras(resultBundle);
				
				setResult(Activity.RESULT_OK,i);
				finish();
				
				}
		});
	}
}
			
			
			
			