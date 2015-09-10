package com.gregbugaj.tabwidgetdemo;

import com.gregbugaj.tabwidget.TabHost;
import com.gregbugaj.tabwidget.TabHostProvider;

import android.app.Activity;
import android.os.Bundle;

public class TabWidgetDemoLauncher extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		TabHostProvider tabProvider=new com.gregbugaj.tabwidgetdemo.DemoTabHostProvider(this);
		TabHost tabHost=tabProvider.getTabHost("main");
		//Tab home=tabHost.getTab("HOME");
		//home.setSelected(true);
		setContentView(tabHost.render());
    }
}