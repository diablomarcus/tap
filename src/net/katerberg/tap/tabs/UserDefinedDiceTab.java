package net.katerberg.tap.tabs;

import java.util.List;

import net.katerberg.tap.CustomDie;
import net.katerberg.tap.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UserDefinedDiceTab extends Activity {
	
	List<CustomDie> customDiceList;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdicetab);
        
        TextView result = (TextView)findViewById(R.id.diceDisplayView);
        LinearLayout customDiceDisplayLayout= (LinearLayout)findViewById(R.id.customDiceRollsLayout);
        result.setText("NOPE");
        
    }
}