package com.enlume.intent.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentsDemo1Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button myGalleryButton = (Button)findViewById(R.id.myGalleryButton);
        Button myCallLogButton = (Button)findViewById(R.id.myCallLogButton);
        Button myContactBookButton = (Button)findViewById(R.id.myContactBookButton);
        
        myGalleryButton.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent();
				myIntent.setAction(Intent.ACTION_VIEW);
				myIntent.setData(android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
				startActivity(myIntent);	
			}
        	
        });
			
        
        myCallLogButton.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent();
				myIntent.setAction(Intent.ACTION_CALL_BUTTON);
				startActivity(myIntent);		
				
			}
			
        });
        
        myContactBookButton.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent();
				myIntent.setAction(Intent.ACTION_VIEW);
				myIntent.setData(android.provider.ContactsContract.Contacts.CONTENT_URI);
				startActivity(myIntent);	
				
			}
			
        });
        
    }
}