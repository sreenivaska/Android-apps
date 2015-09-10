package com.gregbugaj.tabwidgetdemo;

import com.gregbugaj.tabwidget.Tab;
import com.gregbugaj.tabwidget.TabHost;
import com.gregbugaj.tabwidget.TabHostProvider;

import android.os.Bundle;
import android.widget.TextView;

public class Two extends android.app.Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView txt=new TextView(this);
		txt.setText("Another Text Page Two");
		
		TabHostProvider tabProvider=new DemoTabHostProvider(this);
		TabHost tabHost=tabProvider.getTabHost("detail");
		tabHost.setCurrentView(txt);

		setContentView(tabHost.render());
	}
}
