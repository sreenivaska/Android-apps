package com.enlume;



import android.app.ListActivity;
import android.widget.*;
import android.view.View;
import android.os.Bundle;

public class ListItem extends ListActivity{
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        setListAdapter(new ArrayAdapter<String>(this,R.layout.list_item,COUNTRIES));
	        
	        ListView lv = getListView();
	        lv.setTextFilterEnabled(true);
	        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
	        	public void onItemClick(AdapterView<?> parent, View view, int position, long id){
	        		Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
	        	}
	        });
	        
	    }
	    static final String[] COUNTRIES= new String[]{
	    	"Afganistan","Albania","India","Pakistan","Srilanka",
	    	"Bangladesh","Nepal","UK","Japan","Jermany","US","Zimbawe"
	    };

}
