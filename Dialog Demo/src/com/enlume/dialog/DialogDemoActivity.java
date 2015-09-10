package com.enlume.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button alert = (Button) findViewById(R.id.alert);
		Button customList = (Button) findViewById(R.id.customList);
		Button customListRadio = (Button) findViewById(R.id.customListRadio);
		
		alert.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder alert = new AlertDialog.Builder(DialogDemoActivity.this);

				alert.setTitle("This is Alert Dialog");
				alert
						.setMessage("Sample alert dialog");
				alert.setIcon(R.drawable.icon);
				alert.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Toast.makeText(DialogDemoActivity.this, "Success", Toast.LENGTH_SHORT).show();
							}
						});
				alert.setNegativeButton("No",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Toast.makeText(DialogDemoActivity.this, "Fail", Toast.LENGTH_SHORT).show();
							}
						});

				alert.show();
			}
		});
		
		customList.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final CharSequence[] items = {"India", "US", "UK", "Australia"};

				AlertDialog.Builder builder = new AlertDialog.Builder(DialogDemoActivity.this);
				builder.setTitle("Alert Dialog with ListView");
				builder.setIcon(R.drawable.icon);
				builder.setItems(items, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface dialog, int item) {
				        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
				    }
				});
				AlertDialog alert = builder.create();

				alert.show();
			}
		});
		
		customListRadio.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final CharSequence[] items = {"India", "US", "UK", "Australia"};

				AlertDialog.Builder builder = new AlertDialog.Builder(DialogDemoActivity.this);
				builder.setTitle("Alert Dialog with ListView and Radio button");
				builder.setIcon(R.drawable.icon);
				builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface dialog, int item) {
				        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
				    }
				});
				
				builder.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Toast.makeText(DialogDemoActivity.this, "Success", Toast.LENGTH_SHORT).show();
							}
						});
				builder.setNegativeButton("No",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Toast.makeText(DialogDemoActivity.this, "Fail", Toast.LENGTH_SHORT).show();
							}
						});
				AlertDialog alert = builder.create();
				alert.show();
			}
		});
	}
}