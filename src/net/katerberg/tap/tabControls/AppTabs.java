package net.katerberg.tap.tabControls;
/*******************************************************************************
 * Copyright (c) 2012 "Mark Katerberg"
 * 
 * 
 * This file is part of TAP.
 * 
 * Katerproject is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
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
