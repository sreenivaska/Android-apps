package com.enlume.db;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DBDemoActivity extends Activity {
	private static final String DATABASE_NAME = "MYDB.db";
	private static final String DATABASE_TABLE = "myTable";
	private static final String DATABASE_CREATE = "create table "+DATABASE_TABLE+" (_id integer primary key autoincrement, col1 text not null);";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button butCreate = (Button)findViewById(R.id.myButCreate);
        Button butAdd    = (Button)findViewById(R.id.myButAdd);
        Button butCount  = (Button)findViewById(R.id.myButCount);
        Button butShow   = (Button)findViewById(R.id.myButShow);
        
        butCreate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SQLiteDatabase myDB;
				
				myDB = openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
				myDB.execSQL(DATABASE_CREATE);
				myDB.close();				
				Toast.makeText(getApplicationContext(), "Table created", Toast.LENGTH_SHORT).show();
			}      	
        });
        
        butAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SQLiteDatabase myDB;
				
				myDB = openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
				ContentValues newRow = new ContentValues();
				newRow.put("col1", "ok");
				myDB.insert(DATABASE_TABLE, null, newRow);				
				myDB.close();				
				Toast.makeText(getApplicationContext(), "row added", Toast.LENGTH_SHORT).show();
			}       	
        });
        
        butCount.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SQLiteDatabase myDB;
				
				myDB = openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);				
				String[] resultColumns = new String[] {"_id", "col1"};				
				Cursor allRows = myDB.query(DATABASE_TABLE, resultColumns, null, null, null, null, null, null);				
				Integer c = allRows.getCount();				
				myDB.close();				
				Toast.makeText(getApplicationContext(), "count: "+c.toString(), Toast.LENGTH_SHORT).show();
			}    	
        });
        
        butShow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SQLiteDatabase myDB;
				
				myDB = openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
				String[] resultColumns = new String[] {"_id", "col1"};
				Cursor allRows = myDB.query(DATABASE_TABLE, resultColumns, null, null, null, null, null, null);
				String res = "RESULT IS:";
				Integer cindex = allRows.getColumnIndex("col1");
				if (allRows.moveToFirst()) {
					do {
						res += allRows.getString(cindex)+"-";
					} while (allRows.moveToNext());	
				}
				myDB.close();				
				Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
			}
        });
    }
}