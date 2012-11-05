package net.katerberg.tap.tabs;

import java.util.List;

import net.katerberg.tap.AddNewDie;
import net.katerberg.tap.CustomDie;
import net.katerberg.tap.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class UserDefinedDiceTab extends Activity {

	List<CustomDie> customDiceList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_dice_tab);

		TextView result = (TextView)findViewById(R.id.diceDisplayView);
		result.setText("NOPE");
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.userdefineddicemenu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add_new_die:
			startActivity(new Intent(this, AddNewDie.class));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}