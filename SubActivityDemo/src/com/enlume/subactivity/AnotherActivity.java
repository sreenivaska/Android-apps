package com.enlume.subactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AnotherActivity extends Activity {
	public final static int SUCCESS_RETURN_CODE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.another_layout);
		final EditText editView = (EditText) findViewById(R.id.editId);
		editView.setText("another_activity_text");
		Button button = (Button) findViewById(R.id.btnId);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				Bundle b = new Bundle();
				b.putString("text", editView.getText().toString());
				intent.putExtras(b);
				setResult(SUCCESS_RETURN_CODE, intent);
				finish();
			}
		});
	}


}
