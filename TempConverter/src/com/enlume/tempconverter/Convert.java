package com.enlume.tempconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class Convert extends Activity {
	private EditText text;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		text = (EditText) findViewById(R.id.EditText01);

	}

	// This method is called at button click because we assigned the name to the
	// "On Click property" of the button
	public void myClickHandler(View view) {
		switch (view.getId()) {
		case R.id.Button01:
			RadioButton celsiusButton = (RadioButton) findViewById(R.id.RadioButton01);
			RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.RadioButton02);
			float inputValue = Float.parseFloat(text.getText().toString());
			if (celsiusButton.isChecked()) {
				text.setText(String
						.valueOf(convertFahrenheitToCelcius(inputValue)));
			} else {
				text.setText(String
						.valueOf(convertCelciusToFahrenheit(inputValue)));
			}
			// Switch to the other button
			celsiusButton.setChecked(!celsiusButton.isChecked());
			fahrenheitButton.setChecked(!fahrenheitButton.isChecked());
			break;
		}
	}

	// Converts to celcius
	private float convertFahrenheitToCelcius(float fahrenheit) {
		return ((fahrenheit - 32) * 5 / 9);
	}
	// Converts to fahrenheit
	private float convertCelciusToFahrenheit(float celsius) {
		return ((celsius * 9) / 5) + 32;
	}
}
			