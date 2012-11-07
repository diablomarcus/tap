package net.katerberg.tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
				
				String userInput = edit.getText().toString();
				CustomDie userDie = null; 
				if(isInputValid(userInput)){
					userDie = userInputToCustomDie(userInput);
				}
			}


			private CustomDie userInputToCustomDie(String userInput) {
				CustomDie die = new CustomDie();
				die.setModifier(0);
				String[] dSeparator = userInput.split("d");
				Integer numberOfDice=Integer.parseInt(dSeparator[0]);

				String[] mathSeparator = dSeparator[0].split("[+-]");
				Integer typeOfDice = Integer.parseInt(mathSeparator[0]);
				if (mathSeparator.length > 1){
					die.setModifier(Integer.parseInt(mathSeparator[2]));
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
				Pattern validPattern = Pattern.compile("^[0-9]+d[0-9]+[+\\-]?[0-9]+?$");
				Matcher matcher = validPattern.matcher(input);
				if(!matcher.matches()){
					Toast toast = Toast.makeText(getBaseContext(), "invalid input", Toast.LENGTH_SHORT);
					toast.show();
				}
				return matcher.matches();
			}
		};
		
		return acceptCustomDie;
	}
}
