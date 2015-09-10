package com.enlume.subactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivityDemoActivity extends Activity {
	
	TextView textView;
	static final int SUB_ACTIVITY_REQUEST_CODE = 100;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView) findViewById(R.id.textId);
        textView.setText("TextView element");
		Button b = (Button) findViewById(R.id.btnId);
		b.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(SubActivityDemoActivity.this,
						AnotherActivity.class);
				startActivityForResult(i, SUB_ACTIVITY_REQUEST_CODE);
				//startActivityForResult(i, 0);
				//startActivityForResult(i,-1);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
			
		Toast.makeText(this, this.getLocalClassName()+":"+requestCode+":"+resultCode, Toast.LENGTH_SHORT).show();
		if (resultCode == Activity.RESULT_CANCELED) {
		    Log.i("Event:",
		          "AnotherActivity was cancelled or encountered an error. resultcode == result_cancelled");
		  }
		  else
		  {
		Log.d("result code", ""+resultCode);
		if(requestCode == SUB_ACTIVITY_REQUEST_CODE){
				Bundle b = data.getExtras();
				textView.setText(b.getString("text"));
				 Log.i("Event:",
		          "AnotherActivity has successfully processed the result");
       }
	}
	}

    
}