package net.katerberg.tap;

import android.app.Application;
import android.content.Context;

public class TapApplication extends Application{
	private static Context context;

	public void onCreate(){
		super.onCreate();
		context = getApplicationContext();
	}

	public static Context getAppContext() {
		return context;
	}

}
