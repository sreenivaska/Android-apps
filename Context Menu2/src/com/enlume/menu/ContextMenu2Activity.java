package com.enlume.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;
import android.widget.Toast;

public class ContextMenu2Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView tv = (TextView)findViewById(R.id.tv);
        tv.setOnCreateContextMenuListener(this);
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo) {
    	super.onCreateContextMenu(menu, view, menuInfo);
    	menu.setHeaderTitle("Context menu");
    	menu.add(0, Menu.FIRST,   Menu.NONE, "EDIT").setIcon(R.drawable.icon);
    	menu.add(0, Menu.FIRST+1, Menu.NONE, "DELETE");
    	menu.add(0, Menu.FIRST+2, Menu.NONE, "ADD");
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	Toast.makeText(getApplicationContext(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
    	return true;
    }
}