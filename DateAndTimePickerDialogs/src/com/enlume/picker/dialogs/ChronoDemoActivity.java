package com.enlume.picker.dialogs;

import java.text.DateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class ChronoDemoActivity extends Activity {
	
	DateFormat fmtDateAndTime = DateFormat.getDateTimeInstance();
	TextView lblDateAndTime;
	Calendar myCalendar = Calendar.getInstance();
	DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener()
	{
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			
			myCalendar.set(Calendar.YEAR, year);
			myCalendar.set(Calendar.MONTH, monthOfYear);
			myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			updateLabel();
		}
	};
	
	TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener()
	{
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
			myCalendar.set(Calendar.MINUTE, minute);
			updateLabel();
		}
	};
	
	private void updateLabel() {
		lblDateAndTime.setText(fmtDateAndTime.format(myCalendar.getTime()));
		}
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lblDateAndTime = (TextView) findViewById(R.id.lblDateAndTime);
        Button btnDate = (Button) findViewById(R.id.btnDate);
        
        btnDate.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
		        new DatePickerDialog(ChronoDemoActivity.this, d,
		        myCalendar.get(Calendar.YEAR),
		        myCalendar.get(Calendar.MONTH),
		        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
		        }
	        }
        );
        Button btnTime = (Button) findViewById(R.id.btnTime);
        btnTime.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v){ 
		        new TimePickerDialog(ChronoDemoActivity.this, t,
		        myCalendar.get(Calendar.HOUR_OF_DAY),
		        myCalendar.get(Calendar.MINUTE), true).show();
		        }
	        }
        );
        updateLabel();
        }// onCreate
}