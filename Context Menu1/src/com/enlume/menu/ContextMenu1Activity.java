package com.enlume.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;
import android.widget.Toast;

public class ContextMenu1Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView textStartContextMenu = (TextView)findViewById(R.id.startcontextmenu);
        registerForContextMenu(textStartContextMenu);
    }
 
 @Override
 public boolean onContextItemSelected(MenuItem item) {
  // TODO Auto-generated method stub
   
  Toast.makeText(ContextMenu1Activity.this, 
    item.getTitle().toString(), 
    Toast.LENGTH_LONG).show();
   
  return super.onContextItemSelected(item);
 }
 
 @Override
 public void onCreateContextMenu(ContextMenu menu, View v,
   ContextMenuInfo menuInfo) {
  // TODO Auto-generated method stub
  super.onCreateContextMenu(menu, v, menuInfo);
  new MenuInflater(getApplication()).inflate(R.menu.menu, menu);
  
 }
}