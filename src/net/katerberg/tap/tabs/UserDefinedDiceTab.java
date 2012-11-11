package net.katerberg.tap.tabs;
/*******************************************************************************
 * Copyright (c) 2012 "Mark Katerberg"
 * 
 * 
 * This file is part of TAP.
 * 
 * TAP is free software: you can redistribute it and/or modify
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
import helpers.CustomDiceHelper;

import java.util.List;

import beans.CustomDie;

import net.katerberg.tap.AddNewDie;
import net.katerberg.tap.R;
import net.katerberg.tap.db.DbHandler;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;

public class UserDefinedDiceTab extends Activity {

	List<CustomDie> customDiceList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_dice_tab);
		DbHandler dbHandler = new DbHandler(getApplicationContext());
		
		TextView result = (TextView)findViewById(R.id.diceDisplayView);
		result.setText("NOPE");
		LinearLayout customDice = (LinearLayout)findViewById(R.id.customDiceRollsLayout);
		for (CustomDie customDie :  dbHandler.getAllCustomDice()){
			Button button = new Button(this);
			button.setOnClickListener(new CustomDiceHelper(customDie));
			customDice.addView(button);
		}
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
