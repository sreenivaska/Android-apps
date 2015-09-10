package com.enlume.example.loginscreen;

import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginScreen extends Activity {
	EditText txt;
	String str;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ImageButton btn = (ImageButton)findViewById(R.id.btnLoginSignin);
        txt = (EditText)findViewById(R.id.txtLoginEmail);
        btn.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				showStudioEvents();
				//examineJSONFile();
				//txt.setText(txt.getText().toString()+"Hello");
				//txt.setText(str);
			}
        	
        });
    
    }
    
    public void showStudioEvents(){
    	Intent i = new Intent(this,StudioEventsUrl.class);
    	startActivity(i);
    }
    
    
    public void examineJSONFile(){
    	try{
    		//String x="";
    		InputStream is = this.getResources().openRawResource(R.raw.response);
    		byte []buffer = new byte[is.available()];
    		while(is.read(buffer)!=-1);
    		String jsonText = new String(buffer);
    		JSONArray array = new JSONArray();
    		//str = jsonText;
    		//showAlert(str);
    		JSONObject json = new JSONObject(jsonText);
    		if(json.has(names[0])){
    			array = json.getJSONArray(names[0]);
    			//str = names[0]+" : " + json.getString("getAllPhotosUrl");
    		}
    		for(int i=0;i<array.length();i++){
    			JSONObject post = array.getJSONObject(i);
    			if(post.has("id")){
    				
    			}
    		}
    		/*if(json.has(names[1])){
    			str = str+"\n"+ names[1]+" : " + json.getString(names[1]);
    		}*/
    		
    		/*JSONArray entries = new JSONArray(jsonText);
    		str = "There are " + entries.length()+ " entries.";*/
    		Toast.makeText(this, "There are " + json.length()+ " entries.", Toast.LENGTH_SHORT);
    		showAlert("Element in the Array : "+"\n "+ array.length());
    	}catch(Exception e){
    		Toast.makeText(this, "Error" + e, Toast.LENGTH_LONG);
    		str="Error :" + e;
    		showAlert(str);
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
    
    private String []names = {"StudioEvents","setCoverImageUrl"};
}