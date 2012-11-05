package net.katerberg.tap.tabs;

import android.content.Context;
import android.content.Intent;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class AppTabs {
	public static void setMyTabs(TabHost tabHost, Context context){
		TabSpec firstTab = tabHost.newTabSpec("tid1");
        TabSpec secondTab = tabHost.newTabSpec("tid1");

        firstTab.setIndicator("Dice");
        secondTab.setIndicator("Settings");

        firstTab.setContent(new Intent(context, DiceTab.class));
        secondTab.setContent(new Intent(context, SettingsTab.class));

        tabHost.addTab(firstTab);
        tabHost.addTab(secondTab);

        tabHost.getTabWidget().setCurrentTab(0);
        tabHost.setOnTabChangedListener(MyOnTabChangeListener);

	}

	private static OnTabChangeListener MyOnTabChangeListener = new OnTabChangeListener(){

		public void onTabChanged(String tabId) {
		}
	};


}
