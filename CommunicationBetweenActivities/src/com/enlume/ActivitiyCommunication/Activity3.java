package com.enlume.ActivitiyCommunication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity3 extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setTitle(this.getLocalClassName());
		Toast.makeText(this, this.getLocalClassName()+": onCreate", Toast.LENGTH_SHORT).show();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout3);
		
		Button button1 = (Button) findViewById(R.id.l3A1);
		button1.setOnClickListener(new Button.OnClickListener(){

			public void onClick(View arg0) {
				Intent intent = new Intent(Activity3.this,Activity1.class);
				//intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				//intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
				startActivity(intent);
			}
        	
        });
		
		Button button2 = (Button) findViewById(R.id.l3A2);
		button2.setOnClickListener(new Button.OnClickListener(){

			public void onClick(View arg0) {
				Intent intent = new Intent(Activity3.this,Activity2.class);
				//intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				//intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
				//intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
        	
        });
		Button button4 = (Button) findViewById(R.id.l3A4);
		button4.setOnClickListener(new Button.OnClickListener(){

			public void onClick(View arg0) {
				Intent intent = new Intent(Activity3.this,Activity4.class);
				//intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				//intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
				//intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
        	
        });
		
		Button stop = (Button) findViewById(R.id.stopA3);
		stop.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				finish();
			}
        	
        });
		
	/*	Button intentFilter1 = (Button) findViewById(R.id.intentFilter1);
		intentFilter1.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
			//	finish();
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				startActivity(intent);
			}
        	
        });*/
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Toast.makeText(this, this.getLocalClassName()+": onPause", Toast.LENGTH_SHORT).show();
		super.onPause();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onRestart()
	 */
	@Override
	protected void onRestart() {
		Toast.makeText(this, this.getLocalClassName()+": onRestart", Toast.LENGTH_SHORT).show();
		super.onRestart();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Toast.makeText(this, this.getLocalClassName()+": onResume", Toast.LENGTH_SHORT).show();
		super.onResume();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onStart()
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Toast.makeText(this, this.getLocalClassName()+": onStart", Toast.LENGTH_SHORT).show();
		super.onStart();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Toast.makeText(this, this.getLocalClassName()+": onDestroy", Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Toast.makeText(this, this.getLocalClassName()+": onStop", Toast.LENGTH_SHORT).show();
		super.onStop();
	}
}
