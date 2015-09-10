package com.enlume.example.httpdownload;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HttpDownload extends Activity {
	private ImageView img;
	private TextView txt;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        /*String url = "http://www.streetcar.org/mim/cable/images/cable-01.jpg";
        Bitmap bitmap = downloadImage(url);
        img = (ImageView) findViewById(R.id.img);
        img.setImageBitmap(bitmap);*/
        
        String str =
            downloadText("http://analytics.rangeit.com/services/rest/v1/service");
        txt = (TextView) findViewById(R.id.text);
        txt.setText(str);     
    }
    
    
    private InputStream openHttpConnection(String urlString) throws IOException{
    	InputStream in = null;
    	int response =-1;
    	
    	URL url = new URL(urlString);
    	URLConnection conn = url.openConnection();
    	
    	if(!(conn instanceof HttpURLConnection)){
    		throw new IOException("Not an Http Connection");
    	}
    	try{
    		HttpURLConnection httpConn = (HttpURLConnection) conn;
    		//httpConn.setAllowUserInteraction(false);
    		//httpConn.setInstanceFollowRedirects(true);
    		httpConn.setRequestMethod("GET");
    		httpConn.connect();
    		
    		response = httpConn.getResponseCode();
    		if( response == HttpURLConnection.HTTP_OK){
    			in = httpConn.getInputStream();
    			return in;
    		}else{
    			
    		}
    	}catch(Exception ex){
    		throw new IOException("Error Connecting");
    	}
    	return in;
    }
    
    private Bitmap downloadImage(String url){
    	Bitmap bitmap  = null;
    	InputStream in = null;
    	try{
    		in = openHttpConnection(url);
    		bitmap = BitmapFactory.decodeStream(in);
    		in.close();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	return bitmap;
    }
    
    private String downloadText(String url){
    	int BUFFER_SIZE = 2000;
    	InputStream in = null;
    	try{
    		in = openHttpConnection(url);
    		if(in==null){
    			return "Input Stream is Null";
    		}
    	}catch(IOException e){
    		e.printStackTrace();
    		return "";
    	}
    	InputStreamReader isr = new InputStreamReader(in);
    	int charRead;
    	String str="";
    	char [] inputBuffer = new char[BUFFER_SIZE];
    	try{
    		while((charRead = isr.read(inputBuffer)) > 0){
    			String readString = String.copyValueOf(inputBuffer,0,charRead);
    			str += readString;
    			inputBuffer = new char[BUFFER_SIZE];
    		}
    		in.close();
    	}catch(IOException e){
    		e.printStackTrace();
    		return "";
    	}
    	return str;
    }
}