package net.katerberg.tap.tabs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DiceTab extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        TextView textView = new TextView(this);
        textView.setText("Look at these dice");
        setContentView(textView);
    }
}