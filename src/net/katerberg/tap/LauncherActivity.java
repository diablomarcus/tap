package net.katerberg.tap;

import net.katerberg.tap.tabControls.AppTabs;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

public class LauncherActivity extends Activity {

	TabHost tabHost;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);
        tabHost = (TabHost)findViewById(android.R.id.tabhost);
        AppTabs.setMyTabs(tabHost, this);
    }
}