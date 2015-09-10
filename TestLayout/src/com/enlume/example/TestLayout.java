package com.enlume.example;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;


public class TestLayout extends Activity {
    /** Called when the activity is first created. */
	View vg = new View(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}


