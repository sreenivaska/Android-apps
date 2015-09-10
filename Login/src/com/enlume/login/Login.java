package com.enlume.login;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Login extends Activity {
	private String user="";
	private String passwd="";
	private EditText text;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void clickHandler(View view) {
    	text = (EditText)findViewById(R.id.txt_username);
    	user = text.getText().toString();
    	text = (EditText)findViewById(R.id.txt_password);
    	passwd =  text.getText().toString();
		if(user.equals("admin") && passwd.equals("admin")){
			TextView tv = new TextView(this);
			tv.setText("Welcome");
			setContentView(tv);
			
		}else{
			TextView tv = new TextView(this);
			tv.setText("Login Faillure");
			setContentView(tv);
		}
	}
    
}
