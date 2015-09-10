package com.enlume.mt;

import java.util.Date;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AsyncTaskDemoActivity extends Activity {
	Button btnSlowWork;
	Button btnQuickWork;
	EditText etMsg;
	Long startingMillis;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
	etMsg = (EditText) findViewById(R.id.EditText01);
	btnSlowWork = (Button) findViewById(R.id.Button01);
	// slow work...for example: delete all data from a database or get data from Internet
	this.btnSlowWork.setOnClickListener(new OnClickListener() {
	public void onClick(final View v) {
	new VerySlowTask().execute();
	}
	});
	btnQuickWork = (Button) findViewById(R.id.Button02);
	// delete all data from database (when delete button is clicked)
	this.btnQuickWork.setOnClickListener(new OnClickListener() {
	public void onClick(final View v) {
	etMsg.setText((new Date()).toLocaleString());
	}
	});
	}// onCreate
	
	private class VerySlowTask extends AsyncTask <String, Long, Void> {
		private final ProgressDialog dialog = new ProgressDialog(AsyncTaskDemoActivity.this);
		// can use UI thread here
		protected void onPreExecute() {
		startingMillis = System.currentTimeMillis();
		etMsg.setText("Start Time: " + startingMillis);
		this.dialog.setMessage("Wait\nSome SLOW job is being done...");
		this.dialog.show();
		}
		// automatically done on worker thread (separate from UI thread)
		protected Void doInBackground(final String... args) {
		try {
		// simulate here the slow activity
		for (Long i = 0L; i < 3L; i++) {
		Thread.sleep(2000);
		Log.d("event", "In doInBackground with i="+i);
		publishProgress((Long)i);
		}
		} catch (InterruptedException e) {
		Log.v("slow-job interrupted", e.getMessage());
		}
		return null;
		}
		
		// periodic updates - it is OK to change UI
		@Override
		protected void onProgressUpdate(Long... value) {
		super.onProgressUpdate(value);
		Log.d("event", "In onProgressUpdate with value="+value[0]);
		etMsg.append("\nworking..." + value[0]);
		}
		// can use UI thread here
		protected void onPostExecute(final Void unused) {
		if (this.dialog.isShowing()) {
		this.dialog.dismiss();
		}
		// cleaning-up, all done
		etMsg.append("\nEnd Time:"
		+ (System.currentTimeMillis()-startingMillis)/1000);
		etMsg.append("\ndone!");
		}
		}//AsyncTask
}