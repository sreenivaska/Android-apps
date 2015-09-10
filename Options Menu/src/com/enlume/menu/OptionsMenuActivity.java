package com.enlume.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class OptionsMenuActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
    	super.onPrepareOptionsMenu(menu);
    	MenuItem menuItem=menu.findItem(Menu.FIRST+1);
    	menuItem.setEnabled(false);
    	return true;
    }
   
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	TextView tv = (TextView)findViewById(R.id.tv);
    	tv.setText("YOU PUSHED ITEM #"+String.valueOf(item.getItemId()));
    	return true;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	menu.add(0, Menu.FIRST,   Menu.NONE, "ONE").setIcon(R.drawable.ic_menu_barcode);
    	menu.add(0, Menu.FIRST+1, Menu.NONE, "TWO").setIcon(R.drawable.ic_menu_cards).setCheckable(true);
    	menu.add(0, Menu.FIRST+2, Menu.NONE, "THREE").setIcon(R.drawable.ic_menu_chart);
    	menu.add(0, Menu.FIRST+3, Menu.NONE, "FOUR").setIcon(R.drawable.ic_menu_clock);
    	menu.add(0, Menu.FIRST+4, Menu.NONE, "FIVE").setIcon(R.drawable.ic_menu_cloud);
    	menu.add(0, Menu.FIRST+5, Menu.NONE, "SIX").setIcon(R.drawable.ic_menu_dialog).setCheckable(true);
    	menu.add(1, Menu.FIRST+6, Menu.NONE, "SEVEN").setIcon(R.drawable.ic_menu_disc);
    	menu.add(1, Menu.FIRST+7, Menu.NONE, "HEIGHT").setIcon(R.drawable.ic_menu_dice);
    	
    	menu.setGroupCheckable(1, true, true);
    	return true;
    }
}