package com.gregbugaj.tabwidgetdemo;

import android.app.Activity;
import android.content.Intent;

import com.gregbugaj.tabwidget.Tab;
import com.gregbugaj.tabwidget.TabHost;
import com.gregbugaj.tabwidget.TabHostProvider;
import com.gregbugaj.tabwidget.view.TabViewConfig;
/**
 * Demo TabProvider
 * @author gbugaj
 *
 */
public class DemoTabHostProvider extends TabHostProvider {
	private Tab homeTab;
	private Tab createTab;
	private Tab helpTab;
	
	private TabHost tabHost;

	public DemoTabHostProvider(Activity context) {
		super(context);
	}

	@Override
	public TabHost getTabHost(String category) {
		tabHost = new TabHost(
			new TabViewConfig()
			.context(context)
			.headerResourceId(R.drawable.tab_background_55)
			.separatorId(R.drawable.separator)
			.orientation(TabHost.Orientation.BOTTOM)
		);
		
		/**
		 * Defining all the tabs
		 */
		homeTab = new Tab(context, "HOME");
		homeTab.setIcon(R.drawable.home);
		//t1.setIconSelected(R.drawable.home_selected);
		homeTab.setIntent(new Intent(context, TabWidgetDemoLauncher.class));


		createTab = new Tab(context, "EDIT");
		createTab.setIcon(R.drawable.edit_item);
		//t2.setIconSelected(R.drawable.edit_item_selected);
		createTab.setIntent(new Intent(context, One.class));

		helpTab = new Tab(context, "HELP");
		helpTab.setIcon(R.drawable.help);
		//helpTab.setIconSelected(R.drawable.help_selected);
		createTab.setIntent(new Intent(context, Two.class));

		
		if(category.equals("detail")){
			tabHost.addTab(homeTab);
			tabHost.addTab(helpTab);

		}else if(category.equals("main")){
			tabHost.addTab(homeTab);
			tabHost.addTab(createTab);
		}
		
		tabHost.setCurrentView(R.layout.main);
		return tabHost;
	}

}
