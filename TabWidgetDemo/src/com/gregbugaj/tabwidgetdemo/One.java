package com.gregbugaj.tabwidgetdemo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.gregbugaj.tabwidget.TabHost;
import com.gregbugaj.tabwidget.TabHostProvider;

public class One extends android.app.Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView txt=new TextView(this);
		txt.setText("There can be only one");
        int style = Typeface.NORMAL;
                style |= Typeface.BOLD;
                style |= Typeface.ITALIC;

       txt.setTypeface(Typeface.SERIF, style); 
        
		
		TabHostProvider tabProvider=new DemoTabHostProvider(this);
		TabHost tabHost=tabProvider.getTabHost("main");
		tabHost.setCurrentView(txt);	
		
		//Tab t=tabHost.getTab("EDIT");
		//t.setSelected(true);
		
		setContentView(tabHost.render());		
	}
}
