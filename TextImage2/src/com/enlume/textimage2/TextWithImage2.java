package com.enlume.textimage2;





import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class TextWithImage2 extends Activity {
	ListView lv = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        lv=(ListView)findViewById(R.id.listview);
        CustomAdapter adapter = new CustomAdapter(this,mTitles,mThumbIds);
        lv.setAdapter(adapter);
    }
    
    private Integer[] mThumbIds = {
    		R.drawable.icon,R.drawable.stub,
            R.drawable.browse, R.drawable.seal,
            R.drawable.search, R.drawable.settings,
            R.drawable.categories //, R.drawable.sample_7,
            
    };
    
    private String[] mTitles = 
    {
            "Icon",   
            "Stub",
            "Browse",       
            "Seal",
            "Search",
            "Settings",  
            "Categories",
    };
}