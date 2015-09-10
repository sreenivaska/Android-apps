package com.sreeni.voice.example;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends Activity implements OnClickListener{

	private static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;
	    
    Button btnSendSMS;
    EditText txtPhoneNo;
    EditText txtMessage;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
 
        btnSendSMS = (Button) findViewById(R.id.btnSendSMS);
        txtPhoneNo = (EditText) findViewById(R.id.txtPhoneNo);
        txtMessage = (EditText) findViewById(R.id.txtMessage);
        
        // Get display items for later interaction
        Button speakButton = (Button) findViewById(R.id.speak_btn);
        
        // Check to see if a recognition activity is present
        PackageManager pm = getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities( new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        
        if (activities.size() != 0) {
            speakButton.setOnClickListener(this);
        } else {
            speakButton.setEnabled(false);
            speakButton.setText("Recognizer not present");
        }
        
        btnSendSMS.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {                
                String phoneNo = txtPhoneNo.getText().toString();
                String message = txtMessage.getText().toString();                 
                if (phoneNo.length()>0 && message.length()>0){
                	sendSMS(phoneNo, message);                
                }
                else
                    Toast.makeText(getBaseContext(), "Please enter both phone number and message.", Toast.LENGTH_SHORT).show();
            }
        });        
    }  
    
    public void onClick(View v) {
        if (v.getId() == R.id.speak_btn) {
            startVoiceRecognitionActivity();
        }
        else if(v.getId() == R.id.btnSendSMS){
        	
        }
    }

    /**
     * Fire an intent to start the speech recognition activity.
     */
    private void startVoiceRecognitionActivity() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speech SMS demo");
        
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
    }

    /**
     * Handle the results from the recognition activity.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
        	
            ArrayList<String> matches = data.getStringArrayListExtra( RecognizerIntent.EXTRA_RESULTS);
            final String[] items = new String[matches.size()];
            
            Object[] arr = matches. toArray();
            int i = 0;
            for (Object object : arr) {
				String str = object.toString();
				items[i] = str;
				i++;
			}
            
			AlertDialog.Builder builder = new AlertDialog.Builder(SMSActivity.this);
			builder.setTitle("Speech Recognition result List");
			builder.setIcon(R.drawable.ic_launcher);
			builder.setItems(items, new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog, int item) {
			        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
			        String msg = items[item].toString();
			        msg = txtMessage.getText().toString() + " "+msg ;
			        txtMessage.setText(msg);
			    }
			});
			AlertDialog alert = builder.create();
			alert.show();
            
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
    
    
  //---sends an SMS message to another device---
    private void sendSMS(String phoneNumber, String message)
    {        
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, SMSActivity.class), 0);                
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, pendingIntent, null);        
        
        Toast.makeText(getBaseContext(), "Message sent.", Toast.LENGTH_SHORT).show();
    }
    
}
