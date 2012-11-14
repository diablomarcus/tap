package net.katerberg.tap.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import net.katerberg.tap.TapApplication;
import net.katerberg.tap.beans.Die;
import net.katerberg.tap.db.DbHandler;

public class AcceptCustomDieListener implements OnClickListener {
	DbHandler dbHandler;
	EditText edit;
	
	public AcceptCustomDieListener(EditText editText) {
		dbHandler = new DbHandler(TapApplication.getAppContext());
		edit = editText;
	}

	public void onClick(View v) {

		String userInput = edit.getText().toString().toLowerCase();
		Die userDie = null; 
		if(isInputValid(userInput)){
			userDie = userInputToCustomDie(userInput);
		}
		if(userDie != null){
			dbHandler.addCustomDie(userDie);
			Toast toast = Toast.makeText(TapApplication.getAppContext(), "Roll Added", Toast.LENGTH_SHORT);
			toast.show();
			edit.setText("");
		}
	}


	private Die userInputToCustomDie(String userInput) {
		Die die = new Die();
		die.setModifier(0);
		String[] dSeparator = userInput.split("d");
		Integer numberOfDice=Integer.parseInt(dSeparator[0]);

		String[] mathSeparator = dSeparator[1].split("[+-]");
		Integer typeOfDice = Integer.parseInt(mathSeparator[0]);
		if (mathSeparator.length> 1){
			die.setModifier(Integer.parseInt(mathSeparator[1]));
		}

		if (!dSeparator[1].contains("+"))
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
			Toast toast = Toast.makeText(TapApplication.getAppContext(), "Invalid Input", Toast.LENGTH_SHORT);
			toast.show();
		}
		return matcher.matches();
	}
};
