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

import net.katerberg.tap.AddNewDieActivity;
import net.katerberg.tap.R;
import net.katerberg.tap.TapApplication;
import net.katerberg.tap.beans.Die;
import net.katerberg.tap.db.DbHandler;
import net.katerberg.tap.helpers.DiceHelper;
import net.katerberg.tap.helpers.DiceListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class CustomDiceTab extends Activity {

	DbHandler dbHandler; 
	LinearLayout customDice;
	TextView displayView;
	DiceHelper diceHelper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_dice_tab);
		dbHandler = new DbHandler(TapApplication.getAppContext());
		customDice = (LinearLayout)findViewById(R.id.customDiceRollsLayout);
		displayView = (TextView)findViewById(R.id.diceDisplayView);
		diceHelper = new DiceHelper();
		displayView.setText("");

		populateCustomDiceList();
		handleEmptyDisplay();
	}


	@Override
	public void onResume(){
		super.onResume();
		populateCustomDiceList();
		handleEmptyDisplay();
	}

	private void populateCustomDiceList() {
		customDice.removeAllViews();

		for (Die customDie : dbHandler.getAllCustomDice()){
			Button button = new Button(this);
			button.setOnClickListener(new DiceListener(customDie, displayView));
			button.setText(diceHelper.createDieDisplayText(customDie));
			button.setTextSize(25);
			LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			button.setLayoutParams(layoutParams);
			customDice.addView(button);
		}
	}

	private void handleEmptyDisplay() {
		if(dbHandler.getCustomDiceCount()==0){
			customDice.addView(createCustomDieAddButton());
		} 
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.user_defined_dice_menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add_new_die:
			startActivity(new Intent(this, AddNewDieActivity.class));
			return true;
		case R.id.clear_all_dice:
			dbHandler.deleteAllCustomDice();
			onResume();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	private Button createCustomDieAddButton() {
		Button addCustomDie = new Button(this);
		addCustomDie.setText(R.string.add_custom_die);
		addCustomDie.setOnClickListener( new OnClickListener() {

			public void onClick(View v) {
				startActivity(new Intent(TapApplication.getAppContext(), AddNewDieActivity.class));

			}
		}
				);
		return addCustomDie;
	}
}
