package net.katerberg.tap.listeners;
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


import net.katerberg.tap.TapApplication;
import net.katerberg.tap.beans.Die;
import net.katerberg.tap.db.CustomDiceDbHandler;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class AcceptCustomDieListener implements OnClickListener {
	Activity activity;
	CustomDiceDbHandler diceHandler;
	EditText nameEdit;
	EditText sizeEdit;
	EditText numberEdit;
	EditText modifierEdit;

	public AcceptCustomDieListener(Activity activity, EditText nameField, EditText typeField, EditText numberField, EditText modifierField) {
		this.activity = activity;
		diceHandler = new CustomDiceDbHandler(TapApplication.getAppContext());
		nameEdit = nameField;
		sizeEdit = typeField;
		numberEdit = numberField;
		modifierEdit = modifierField;
	}

	public void onClick(View v) {
		Integer numberVal, sizeVal;
		
		String nameText = nameEdit.getText().toString();
		Integer modifierVal = getModifierValue(modifierEdit.getText().toString());
		if (null == modifierVal){
			return;
		}
		try{
			sizeVal = Integer.parseInt(sizeEdit.getText().toString());
			numberVal= Integer.parseInt(numberEdit.getText().toString());
		} catch (NumberFormatException e){
			Toast toast = Toast.makeText(TapApplication.getAppContext(), "Invalid inputs", Toast.LENGTH_SHORT);
			toast.show();
			return;
		}
		Die userDie = new Die(nameText, numberVal, sizeVal, modifierVal);
		if (userDie != null) {
			diceHandler.addCustomDie(userDie);
			Toast toast = Toast.makeText(TapApplication.getAppContext(), "Roll Added", Toast.LENGTH_SHORT);
			toast.show(	);
			clearInputs();
			activity.finish();
		}
	}

	private void clearInputs() {
		nameEdit.setText("");
		numberEdit.setText("");
		modifierEdit.setText("");
		sizeEdit.setText("");		
	}

	private Integer getModifierValue(String modifierString) {
		if(null == modifierString || "" == modifierString || modifierString.length()==0){
			return 0;
		} else {
		
			try{
				return Integer.parseInt(modifierString);
			} catch (NumberFormatException e){
				Toast toast = Toast.makeText(TapApplication.getAppContext(), "Invalid modifier input", Toast.LENGTH_SHORT);
				toast.show();
				return null;
			}
		}
	}
};