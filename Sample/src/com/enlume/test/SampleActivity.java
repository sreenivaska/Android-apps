package com.enlume.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout lin=new LinearLayout(SampleActivity.this);
        Button bt=new Button(SampleActivity.this);
        bt.setText("sample");
        lin.addView(bt);
        setContentView(lin);
    }
}