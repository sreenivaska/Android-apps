package com.enlume.events;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;

public class KeyboardEventHandlerActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.keyboard);
		 final TextView tv_View = (TextView)findViewById(R.id.testText);
		    final EditText et_Text = (EditText)findViewById(R.id.editText);
		        
		    //add new KeyListener Callback (to record key input)
		    et_Text.setOnKeyListener(new OnKeyListener()
		    {
		        //function to invoke when a key is pressed
		        public boolean onKey(View v, int keyCode, KeyEvent event)
		        {
		            //check if there is 
		            if (event.getAction() == KeyEvent.ACTION_DOWN)
		            {
		                //check if the right key was pressed
		                if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER)
		                {
		                                    //add the text to the textview
		                    tv_View.setText(tv_View.getText() + ", " + 
		                                     et_Text.getText());
		                                    //and clear the EditText control
		                    et_Text.setText("");
		                    return true;
		                }
		            }
		            return false;
		        }
		    });
	}

}
