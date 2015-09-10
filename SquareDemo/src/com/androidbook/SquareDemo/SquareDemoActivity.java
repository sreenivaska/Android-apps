package com.androidbook.SquareDemo;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SquareDemoActivity extends Activity {
    /** Called when the activity is first created. */
	EditText editText;
	private static final int NextActivity_REQUEST_CODE = 100;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        editText= (EditText) findViewById(R.id.text);
        editText.setText(" ");
		Button b = (Button) findViewById(R.id.but1);
		b.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Bundle b = new Bundle();
				Log.d("value=", editText.getText().toString());
				Integer enteredValue=Integer.parseInt(editText.getText().toString().trim());
				b.putInt("value", enteredValue.intValue());
				Intent i = new Intent(SquareDemoActivity.this,NextActivity.class);
				i.putExtras(b);
				startActivityForResult(i, 100);
			}
		});
    }


    protected void onActivityResult(int requestcode,int resultcode,Intent data){
		super.onActivityResult(requestcode, resultcode, data);

		if(requestcode==NextActivity_REQUEST_CODE) {
		Bundle bundle=data.getExtras();
		editText.setText(bundle.getString("square"));
		Toast.makeText(this,"result="+bundle.getString("square"),Toast.LENGTH_SHORT).show();
			}
    }
}
				
	
        