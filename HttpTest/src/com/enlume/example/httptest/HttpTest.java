package com.enlume.example.httptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HttpTest extends Activity {
	int response=-1;
	private String urlString ="http://analytics.rangeit.com/services/rest/v1/service";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        Button btnSave = (Button)findViewById(R.id.btn_user_save);
		btnSave.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//getConnection();
				postData();
			}
		});

      
    }

    public void getConnection(){
    	String type="application/xml";
    	String xmlStr = generateXML();
    	byte encoded[]=null;
    	String str="";
		try {
			encoded = xmlStr.getBytes("UTF-8");
			str= encoded.toString();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	showAlert(str);
    	try {
    		//showAlert("Into Try");
    		URL url = new URL(urlString);
    		URLConnection conn = url.openConnection();
    		//showAlert("Connection is open");
    		HttpURLConnection httpConn = (HttpURLConnection) conn;
    		
    		if(!(conn instanceof HttpURLConnection)){
	    		throw new IOException("Not an Http Connection");
			}
    		httpConn.setRequestMethod("POST");
    		httpConn.setDoOutput(true);
    		httpConn.setAllowUserInteraction(true);
    		httpConn.setRequestProperty( "HTTP-Version", "1.1" );
    		httpConn.setRequestProperty( "Content-Type", type );
    		httpConn.setRequestProperty( "Content-Length",encoded.length+"" );
    		httpConn.setDoOutput(true);
    		
    
    		showAlert("Connection is open");
    		
    		httpConn.connect();
    		
    		showAlert("Connection is done");
    		response = httpConn.getResponseCode();
    		if( response == HttpURLConnection.HTTP_OK){
    			showAlert("Connected");
    		}else{
    			showAlert("Not connected" + response);
    		}

    	} catch (MalformedURLException e) {
    		// TODO Auto-generated catch block
    		showAlert("Malformed Exception" + e);
    		e.printStackTrace();
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		showAlert("IO Exception" + e);
    		e.printStackTrace();
    	}finally{
    		showAlert("Response Code " + response);
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
    
    public String generateXML(){
		StringBuilder sb;

		sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("\n");
		sb.append("<ServiceRequest>");
		sb.append("\n");
		sb.append("<ServiceRequestHeader id=\"0\" deviceID=\""+mid +"\" />");
		sb.append("\n");
		sb.append("<ServiceRequestBody>");
		sb.append("\n");
		sb.append("<NV name=\"userName\" value=\"\" />");
		sb.append("\n");
		sb.append("<NV name=\"versionName\" value=\"PasswdMgr\" />");
		sb.append("\n");
		sb.append("<NV name=\"versionDate\" value=\"08-16-2010\" />");
		sb.append("\n");
		sb.append("<NV name=\"emailID\" value=\" "+ emailid+" \" />");
		sb.append("\n");
		sb.append("<NV name=\"firstName\" value=\" "+ fname +" \" />");
		sb.append("\n");
		sb.append("<NV name=\"lastName\" value=\" "+ lname+" \" />");
		sb.append("\n");
		sb.append("<NV name=\"contactNumber\" value=\" "+ phno+" \" />");
		sb.append("\n");
		sb.append("</ServiceRequestBody>");
		sb.append("\n");
		sb.append("</ServiceRequest>");
		String xmlStr = new String(sb);
		return xmlStr;

	}
    
    public void postData(){
    	String result="Hi";
    	HttpClient httpClient = new DefaultHttpClient();
    	HttpPost httpPost = new HttpPost(urlString);
    	String xmlStr= generateXML();
    	try{
    		httpPost.setEntity(new StringEntity(xmlStr));
    		
    		HttpResponse response = httpClient.execute(httpPost);
    		int res = response.getStatusLine().getStatusCode();
    		//ResponseHandler<String> handler = new BasicResponseHandler(); 
    		//result = httpClient.execute(httpPost, handler);
    		
    		String message = response.getStatusLine().getReasonPhrase();
    		showAlert("Response : \n CODE :" + res +"\n Message : "+ message);
    		
    		HttpEntity entity = response.getEntity();
    		 
            if (entity != null) {
 
                InputStream instream = entity.getContent();
                result = convertStreamToString(instream);
                showAlert("Result :\n " + result);
                // Closing the input stream will trigger connection release
                instream.close();
            }
 


    		
    	}catch(Exception e){
    		showAlert("Exception:   "+e);
    	}
    	
    	


    
    	
    }
    
    private static String convertStreamToString(InputStream is) {
		 
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
 
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    
    String mid="XXXXXXX";
    String emailid="first@last.com";
    String fname = "First";
    String lname="Last";
    String phno="33333333333";

}