package com.enlume.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProgressBarDemoActivity extends Activity {
	 ProgressDialog mDialog1;
	    ProgressDialog mDialog2;

	    private static final int DIALOG1_KEY = 0;
	    private static final int DIALOG2_KEY = 1;


	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        setContentView(R.layout.main);

	        Button button = (Button) findViewById(R.id.showIndeterminate);
	        button.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                showDialog(DIALOG1_KEY);
	            }
	        });

	        button = (Button) findViewById(R.id.showIndeterminateNoTitle);
	        button.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                showDialog(DIALOG2_KEY);
	            }
	        });
	    }

	    @Override
	    protected Dialog onCreateDialog(int id) {
	        switch (id) {
	            case DIALOG1_KEY: {
	                ProgressDialog dialog = new ProgressDialog(this);
	                dialog.setTitle("Indeterminate");
	                dialog.setMessage("Please wait while loading...");
	                dialog.setIndeterminate(true);
	                dialog.setCancelable(true);
	                return dialog;
	            }
	            case DIALOG2_KEY: {
	                ProgressDialog dialog = new ProgressDialog(this);
	                dialog.setMessage("Please wait while loading...");
	                dialog.setIndeterminate(true);
	                dialog.setCancelable(true);
	                return dialog;
	            }
	        }
	        return null;
	    }
}