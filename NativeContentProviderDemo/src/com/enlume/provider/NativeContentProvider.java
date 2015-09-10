package com.enlume.provider;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class NativeContentProvider extends Activity {
	private Uri insertUri = null;
	private Uri updateUri = null; 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nativecontentprovider);

            Button view = (Button)findViewById(R.id.viewButton);
            Button add = (Button)findViewById(R.id.createButton);
            Button modify = (Button)findViewById(R.id.updateButton);
            Button delete = (Button)findViewById(R.id.deleteButton);
            
            
            view.setOnClickListener(new OnClickListener() {
             	public void onClick(View v){
            		displayContacts();
            		Log.i("NativeContentProvider", "Completed Displaying Contact list");
            	}
            });

            add.setOnClickListener(new OnClickListener() {
             	public void onClick(View v){
            		createContact("Sample Name", "123456789");
            		Log.i("NativeContentProvider", "Created a new contact, of course hard-coded");
            	}
            });
            
            modify.setOnClickListener(new OnClickListener() {
            	public void onClick(View v) {
            		updateContact("0987654321");
            		Log.i("NativeContentProvider", "Completed updating the phone number, if applicable");
            	}
            });
            
            delete.setOnClickListener(new OnClickListener() {
            	public void onClick(View v) {
            		deleteContact();
            		Log.i("NativeContentProvider", "Deleted the just created contact");
            	}
            });
    }
    
    private void displayContacts() {
    	String[] columns = new String[] {People.NAME,People.NUMBER};
    	Uri mContacts = People.CONTENT_URI;
    	Cursor mCur = managedQuery(mContacts,columns,null,null,null);
    	if (mCur.moveToFirst()) {
    		String name = null;
    		String phoneNo = null;
    		do {
    			name = mCur.getString(mCur.getColumnIndex(People.NAME));
    			phoneNo = mCur.getString(mCur.getColumnIndex(People.NUMBER));
    			Toast.makeText(NativeContentProvider.this, name + " " + phoneNo, Toast.LENGTH_SHORT).show();
    		} while (mCur.moveToNext());
    	}
    }
    
    private void createContact(String name, String phone) {
    	ContentValues contact = new ContentValues();
    	contact.put(People.NAME, name);
    	insertUri = getContentResolver().insert(People.CONTENT_URI, contact);
    	Log.d(getClass().getSimpleName(),insertUri.toString());
    	Uri phoneUri = Uri.withAppendedPath(insertUri, People.Phones.CONTENT_DIRECTORY);
    	contact.clear();
    	contact.put(People.Phones.TYPE, People.TYPE_MOBILE);
    	contact.put(People.NUMBER, phone);
    	updateUri = getContentResolver().insert(phoneUri, contact);
    	Toast.makeText(NativeContentProvider.this, "Created a new contact: " + name + " " + phone, Toast.LENGTH_SHORT).show();
    	Log.d(getClass().getSimpleName(),updateUri.toString());
    }
    
    private void updateContact(String phone) {
    	if (updateUri == null) {
    		Toast.makeText(NativeContentProvider.this, "There is nothing to update, Please create a contact and then click update", Toast.LENGTH_LONG).show();
    	} else {
    		ContentValues newPhone = new ContentValues();
    		newPhone.put(People.Phones.TYPE, People.TYPE_MOBILE);
    		newPhone.put(People.NUMBER, phone);
    		getContentResolver().update(updateUri, newPhone, null,null);
    		Toast.makeText(NativeContentProvider.this, "Updated the phone number to: " + phone, Toast.LENGTH_SHORT).show();
    		Log.i(getClass().getSimpleName(), "Updated the phone number");
    	}
    }
    
    private void deleteContact() {
    	if (updateUri == null) {
    		Toast.makeText(NativeContentProvider.this, "Please create a contact by clicking create button, then I can delete the same", Toast.LENGTH_LONG).show();
    		
    	} else {
    		getContentResolver().delete(insertUri, null, null);
    		Toast.makeText(NativeContentProvider.this, "Deleted contact at: " + insertUri.toString(), Toast.LENGTH_SHORT).show();
    		updateUri = null;
    		insertUri = null;
    		Log.i(getClass().getSimpleName(),"Deleted the contact inserted by this program");
    	}
    }
}