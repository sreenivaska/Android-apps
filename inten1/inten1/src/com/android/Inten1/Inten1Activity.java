package com.android.Inten1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inten1Activity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button gallery = (Button)findViewById(R.id.b1);
		Button contacts = (Button)findViewById(R.id.b2);
		Button calllog = (Button)findViewById(R.id.b3);

		gallery.setOnClickListener(new View.OnClickListener(){ 

			public void onClick(View v) 
			{
				Intent i1 = new Intent();
				i1.setAction(Intent.ACTION_VIEW);
				i1.setData(android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
				startActivity(i1);

			}
		});
		contacts.setOnClickListener(new View.OnClickListener(){ 

			public void onClick(View v) 
			{
				Intent i = new Intent();
				i.setAction(Intent.ACTION_CALL);
				i.setData(android.provider.ContactsContract.Contacts.CONTENT_URI);
				startActivity(i);

			}
		});
		calllog.setOnClickListener(new View.OnClickListener(){ 

			public void onClick(View v) 
			{
				Intent i1 = new Intent();
				i1.setAction(Intent.ACTION_CALL_BUTTON);
				startActivity(i1);

			}
		});
	}
}