package com.enlume.example.loginscreen;

import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListView;

public class StudioEventsUrl extends Activity{
	 ListView list;
	 ImageAdapter adapter;
	 public void onCreate(Bundle savedInstanceState){
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.studio_events);
		 getResponse();

		 list=(ListView)findViewById(R.id.list);
		 adapter=new ImageAdapter(this, imgurl,title,code,date,status);
		 list.setAdapter(adapter);

	 }

	 public void onDestroy(){
		 adapter.imageLoader.stopThread();
		 list.setAdapter(null);
		 super.onDestroy();
	 }

	public void getResponse(){
		try{
			InputStream is = this.getResources().openRawResource(R.raw.response);
			byte []buffer = new byte[is.available()];
			while(is.read(buffer)!=-1);
			String jsonText = new String(buffer);
			JSONArray array = new JSONArray();
			
			JSONObject json = new JSONObject(jsonText);
			if(json.has("StudioEvents")){
				array = json.getJSONArray("StudioEvents");
				
			}
			// Instantiating the Different Arrays
			int len = array.length();
			imgurl = new String[len];
			code = new String[len];
			title = new String[len];
			date = new String[len];
			status = new String[len];
			String str;
			int i=0;
			String names[]={"id","title","coverImageUrl","status","eventDate"};
			for(i=0;i<array.length();i++){
				JSONObject post = array.getJSONObject(i);
				for(int j=0;j<names.length;j++)
				if(post.has(names[j])){
					str = post.getString(names[j]);
					switch(j){
					case 0:
						code[i]=str;
					break;
					case 1:
						title[i]=str;
					break;
					case 2:
						imgurl[i]=str;
					break;
					case 3:
						status[i]=str;
					break;
					case 4:
						date[i]=str;
					break;
					}
					
				}
			}
			
			showAlert(title[0]+"\n"+code[0]+"\n"+imgurl[0]);
			
		}catch(Exception e){
			//Toast.makeText(this, "Error" + e, Toast.LENGTH_LONG);
			//str="Error :" + e;
			showAlert("Error" + e);
		}
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
	    
	
	private String imgurl[];
	private String title[];
	private String code[];
	private String date[];
	private String status[];
}
