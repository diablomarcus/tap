package net.katerberg.tap.tabControls;

import net.katerberg.tap.tabs.DiceTab;
import net.katerberg.tap.tabs.SettingsTab;
import net.katerberg.tap.tabs.UserDefinedDiceTab;
import android.content.Context;
import android.content.Intent;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class AppTabs {
	
	private static OnTabChangeListener MyOnTabChangeListener = new OnTabChangeListener(){
		
		public void onTabChanged(String tabId) {
		}
	};

	public static void setMyTabs(TabHost tabHost, Context context){
		TabSpec firstTab = tabHost
				.newTabSpec("Tab 1")
				.setIndicator("Dice")
				.setContent(new Intent(context, DiceTab.class));

		TabSpec secondTab = tabHost
				.newTabSpec("Tab 2")
				.setIndicator("Custom Dice")
				.setContent(new Intent(context, UserDefinedDiceTab.class));
        
		TabSpec thirdTab = tabHost
				.newTabSpec("Tab 3")
				.setIndicator("Settings")
				.setContent(new Intent(context, SettingsTab.class));

		
        tabHost.addTab(firstTab);
        tabHost.addTab(secondTab);
        tabHost.addTab(thirdTab);

        tabHost.getTabWidget().setCurrentTab(0);
        tabHost.setOnTabChangedListener(MyOnTabChangeListener);
	}
}