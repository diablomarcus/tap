package net.katerberg.tap;
/*******************************************************************************
 * Copyright (c) 2012 "Mark Katerberg"
 * 
 * 
 * This file is part of TAP.
 * 
 * Katerproject is free software: you can redistribute it and/or modify
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import beans.CustomDie;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewDie extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_custom_die);
		EditText inputField = (EditText)findViewById(R.id.customDieInput);
		((Button)this.findViewById(R.id.acceptCustomDie)).setOnClickListener(createAcceptCustomDieListener(inputField));
	}

	private OnClickListener createAcceptCustomDieListener(final EditText edit) {

		OnClickListener acceptCustomDie = new OnClickListener() {

			public void onClick(View v) {
				
				String userInput = edit.getText().toString().toLowerCase();
				CustomDie userDie = null; 
				if(isInputValid(userInput)){
					userDie = userInputToCustomDie(userInput);
				}
				if(userDie != null){
					edit.setText("Max val is " + userDie.getMaxValue() 
							+ " modifier is " + userDie.getModifier()
							+ " number of dice are/is " + userDie.getNumberOfDice());
				}
			}


			private CustomDie userInputToCustomDie(String userInput) {
				CustomDie die = new CustomDie();
				die.setModifier(0);
				String[] dSeparator = userInput.split("d");
				Integer numberOfDice=Integer.parseInt(dSeparator[0]);

				String[] mathSeparator = dSeparator[1].split("[+-]");
				Integer typeOfDice = Integer.parseInt(mathSeparator[0]);
				if (mathSeparator.length> 1){
					die.setModifier(Integer.parseInt(mathSeparator[1]));
				}

				if (dSeparator[0].contains("-"))
				{
					die.setModifier(die.getModifier()*-1);
				}

				die.setMaxValue(typeOfDice);
				die.setNumberOfDice(numberOfDice);
				return die;
			}

			private Boolean isInputValid(String input) {
				
				Pattern validPattern = Pattern.compile("^[0-9]+d[0-9]+([+\\-][0-9]+)?$");
				
				Matcher matcher = validPattern.matcher(input.trim());
				if(!matcher.matches()){
					Toast toast = Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_SHORT);
					toast.show();
				}
				return matcher.matches();
			}
		};
		
		return acceptCustomDie;
	}
}
