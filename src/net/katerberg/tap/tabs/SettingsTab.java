package net.katerberg.tap.tabs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SettingsTab extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        TextView textView = new TextView(this);
        textView.setText("Here are some settings. If you can't see them, then you're not special enough.");
        setContentView(textView);
    }
}