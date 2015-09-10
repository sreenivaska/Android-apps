package com.enlume.events;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;

public class OnLongClickEventHandlerActivity extends Activity implements OnClickListener,
		OnLongClickListener {
	
	  /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button)findViewById(R.id.testButton);
        button.setOnClickListener(this);
        button.setOnLongClickListener(this);
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		TextView text = (TextView)findViewById(R.id.testText);
		text.setText("BUTTON HAS BEEN CLICKED. EVENT PROCESSED.");

	}

	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		TextView text = (TextView)findViewById(R.id.testText);
		text.setText("BUTTON HAS BEEN LONG HELD. LONGCLICK EVENT PROCESSED.");
		return false;
	}

}
