package com.enlume.customlist;







import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class CustomList extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setListAdapter(new CustomListAdapter(this));
        
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id) 
    {    
    	CustomListAdapter cust = (CustomListAdapter)l.getAdapter();
    	showAlert("Hello   "  +   cust.getTitle(position));      
    }
    
    
    private class CustomListAdapter extends BaseAdapter {
        public CustomListAdapter(Context context)
        {
            mContext = context;
        }


        public int getCount() {
            return mTitles.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }
        
        public String getTitle(int position){
        	return mTitles[position];
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            CustomView sv;
            if (convertView == null) {
                sv = new CustomView(mContext, mTitles[position], mThumbIds[position]);
            } else {
                sv = (CustomView)convertView;
                sv.setTitle(mTitles[position]);
                sv.setImage(mThumbIds[position]);
              
            }

            return sv;
        }

   
        private Context mContext;

        
        private String[] mTitles = 
        {
                "Moti",   
                "Sheru",
                "Lion",       
                "Tiger",
                "King",
                "Moti II",  
                "Tiger II",
                "DOGA"
        };
        
        private Integer[] mThumbIds = {
        		R.drawable.sample_0,R.drawable.sample_1,
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7,
                
        };

        
    }

    
    
    private class CustomView extends LinearLayout {
        public CustomView(Context context, String title, int thumb) {
            super(context);

            this.setOrientation(HORIZONTAL);
            mTitle = new TextView(context);
            mTitle.setText(title);
            addView(mTitle, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

            mImage = new ImageView(context);
            mImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImage.setPadding(8, 8, 8, 8);
            mImage.setImageResource(thumb);
           
            
            addView(mImage, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

           
        }

        
        public void setTitle(String title) {
            mTitle.setText(title);
        }

        public void setImage(int pos) {
        	 mImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        	mImage.setPadding(8, 8, 8, 8);
        	mImage.setImageResource(pos);
        }

        private TextView mTitle;
        private ImageView mImage;
        
       
    }
    
    
    public void showAlert(CharSequence s){
    	AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
    	alertbox.setMessage(s);
    	alertbox.setNeutralButton("OK",new DialogInterface.OnClickListener(){
    		public void onClick(DialogInterface arg0,int arg1){
    			
    		}
    	});
    	alertbox.show();
    }
   
}