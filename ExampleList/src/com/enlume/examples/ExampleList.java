package com.enlume.examples;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ExampleList extends Activity {
	
 private static class EfficientAdapter extends BaseAdapter {
    

	private LayoutInflater mInflater;
     public EfficientAdapter(Context context) {
    	 mInflater = LayoutInflater.from(context);
     }

    public int getCount() {
    	return country.length;
   }

    public Object getItem(int position) {
    	return position;
    }

    public long getItemId(int position) {
    	return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
    	final ViewHolder holder;
    	if (convertView == null) {
    		convertView = mInflater.inflate(R.layout.listview, null);
    		holder = new ViewHolder();
    		holder.text = (TextView) convertView.findViewById(R.id.TextView01);
    		holder.image = (ImageView) convertView.findViewById(R.id.image);
    		
    		convertView.setTag(holder); 
    	} else {
    		holder = (ViewHolder) convertView.getTag();
    	}
    	holder.text.setText(curr[position]);
    	holder.image.setClickable(true);
    	/*holder.image.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Toast.makeText(null, holder.text.getText(), Toast.LENGTH_SHORT).show();
			}
		});*/
		
    	return convertView;
    }

    static class ViewHolder {
    	TextView text;
    	ImageView image;
    }
 }

 @Override

 public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);

     setContentView(R.layout.main);

      ListView l1 = (ListView) findViewById(R.id.ListView01);
      l1.setAdapter(new EfficientAdapter(this));
      l1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
      	public void onItemClick(AdapterView<?> parent, View view, int position, long id){
      		
      		//String str=((TextView) view).getText().toString();
      		//showAlert("Position" + position);
      		
      	}
      });
      
     

 }
 
 public void showAlert(CharSequence s){
 	AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
 	alertbox.setMessage(s);
 	alertbox.setNeutralButton("Ok",new DialogInterface.OnClickListener(){
 		public void onClick(DialogInterface arg0,int arg1){
 			
 		}
 	});
 	alertbox.show();
 }



 private static final String[] country = { "Iceland", "India", "Indonesia",

 "Iran", "Iraq", "Ireland", "Israel", "Italy", "Laos", "Latvia",

 "Lebanon", "Lesotho ", "Liberia", "Libya", "Lithuania",

 "Luxembourg" };

 private static final String[] curr = { "ISK", "INR", "IDR", "IRR", "IQD",

 "EUR", "ILS", "EUR", "LAK", "LVL", "LBP", "LSL ", "LRD", "LYD",

 "LTL ", "EUR"

 

 };

 
 
}
