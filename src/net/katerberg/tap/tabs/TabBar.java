package net.katerberg.tap.tabs;

import net.katerberg.tap.R;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class TabBar extends TabActivity  {
		 
    TabHost tabHost;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);
 
        tabHost = (TabHost)findViewById(android.R.id.tabhost);
        AppTabs.setMyTabs(tabHost, this);
    }
}

