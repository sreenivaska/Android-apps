package com.enlume.example.hellowebservice;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HelloWebService extends Activity {
	String URL="http://analytics.rangeit.com/services/rest/v1/service";
	String result="Hi";
	String deviceID="XXXXXXXX";
	TextView tv;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = (TextView) findViewById(R.id.text);
        callWebService(URL);
        tv.setText(result);
        
    }
    
    public void callWebService(String url){
    	HttpClient httpClient = new DefaultHttpClient();
    	HttpPost request  = new HttpPost(URL);
    	
    	request.addHeader("deviceId", deviceID);  
        ResponseHandler<String> handler = new BasicResponseHandler();  
        try {  
            result = httpClient.execute(request, handler);  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        httpClient.getConnectionManager().shutdown();  
        //Log.i(tag, result);  
    } // end callWebService()  
 
}
