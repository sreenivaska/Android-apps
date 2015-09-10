package com.enlume.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class SubMenuDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public boolean onOptionsItemSelected(MenuItem item)
    {
            switch (item.getItemId())
    {
                    case R.id.Menu1:
                            Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                            break;
                    case R.id.submenu:
                            Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                            break;
                    case R.id.Menu3:
                            Toast.makeText(this, "Copy", Toast.LENGTH_SHORT).show();
                            break;
                    case R.id.Menu4:
                            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                    break;
            }
            return(super.onOptionsItemSelected(item));
    }
    
    public boolean onCreateOptionsMenu(Menu menu)
    {
            new MenuInflater(getApplication()).inflate(R.menu.menu, menu);
    return(super.onPrepareOptionsMenu(menu));
    }

}