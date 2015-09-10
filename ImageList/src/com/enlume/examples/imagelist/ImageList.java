package com.enlume.examples.imagelist;







import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ImageList extends ListActivity  {
	private ListView lv = null;
	//private Drawable star;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	    	
    	
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.categories);
       // DataHelper dh = new DataHelper(this);
        setListAdapter(new ArrayAdapter<ImageAndText>(this,R.layout.image,setImage()));
        
        lv = getListView();   //.setEmptyView(R.id.empty);
        lv.setTextFilterEnabled(true);
      /*  lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        		Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
        	}
        });*/
       
     

		
		
        
    }
    
    public ImageAndText[] setImage(){
    	 ImageAndText img []= new ImageAndText[5];
    	 img[0]= new ImageAndText("India");
    	 img[1] = new ImageAndText("Pakistan");
    	 
    	 return img;
    	 
    	
    }
   
    
    static final String[] COUNTRIES= new String[]{
    	"Afganistan","Albania","India","Pakistan","Srilanka",
    	"Bangladesh","Nepal","UK","Japan","Jermany","US","Zimbawe"
    };
    
}
