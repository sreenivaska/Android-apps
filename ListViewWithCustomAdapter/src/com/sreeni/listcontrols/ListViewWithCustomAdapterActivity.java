package com.sreeni.listcontrols;

import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewWithCustomAdapterActivity extends ListActivity {
	
	String[] options ;
	String[] capitals;
	TypedArray icons;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Context ctx = getApplicationContext();
		Resources res = ctx.getResources();

		options = res.getStringArray(R.array.country_names);
		capitals=res.getStringArray(R.array.country_cap_names);
		icons = res.obtainTypedArray(R.array.country_icons);
		
		setListAdapter(new ImageAndTextAdapter(ctx, R.layout.main_list_item,
				options,capitals,icons));
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Toast.makeText(this,"You have chosen the country: "+options[position]+" whose capital is: "+capitals[position], Toast.LENGTH_SHORT).show();
	}
    
    
}