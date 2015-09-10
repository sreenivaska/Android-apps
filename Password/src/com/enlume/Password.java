package com.enlume;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.view.View.OnClickListener;

public class Password extends Activity implements OnClickListener {
	private String user="";
	private String passwd="";
	private EditText text;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btnOk = (Button) findViewById(R.id.btn_sign_in);
        btnOk.setOnClickListener(this);
    }
    
    public void onClick(View view) {
    	//Intent intent;
    	text = (EditText)findViewById(R.id.txt_username);
    	user = text.getText().toString();
    	text = (EditText)findViewById(R.id.txt_password);
    	passwd =  text.getText().toString();
		if(user.equals("admin") && passwd.equals("admin")){
			/*intent  = new Intent();
			intent.setClass(this,ListItem.class);
			startActivity(intent);*/
			Intent i = new Intent(this,ListItem.class);
			startActivity(i);
			/*TextView tv = new TextView(this);
			tv.setText("Success");
			setContentView(tv);*/
			
			
		}else{
			TextView tv = new TextView(this);
			tv.setText("Login Faillure");
			setContentView(tv);
		}
	}
    
}