package com.elc.Gallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Gallery1 extends Activity {
   
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button gallery=(Button) findViewById(R.id.b1);
        Button contacts=(Button) findViewById(R.id.b2);
        Button calllog=(Button) findViewById(R.id.b3);
        
        gallery.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent1= new Intent();
				intent1.setAction(Intent.ACTION_VIEW);
				intent1.setData(android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
				startActivity(intent1);
			}
		});
        contacts.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent1=new Intent();
				intent1.setAction(Intent.ACTION_VIEW);
				intent1.setData(android.provider.ContactsContract.Contacts.CONTENT_URI);
				startActivity(intent1);
				
			}
		});
        calllog.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent1=new Intent();
				intent1.setAction(Intent.ACTION_VIEW);
				intent1.setData(android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
				startActivity(intent1);
				
			}
		});
    }
}