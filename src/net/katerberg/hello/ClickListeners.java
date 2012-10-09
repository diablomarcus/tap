package net.katerberg.hello;

import java.util.List;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class ClickListeners {

	public static OnClickListener getDisplayClickListener(final TextView outputField, final DbHandler inputDb){
		return new OnClickListener() {
	    	public void onClick(View v) {
	    		String outputString="";
	    		
	    		Log.d("DB: ", "Getting all DB fields");
	    		List<Input> inputList = inputDb.getAllInput();
	    		for(Input i : inputList){
	    			outputString += i.getText()+"\n";
	    		}
	    		outputField.setText(outputString);
			}
		};
		
	}
	
	public static OnClickListener getClearClickListener(final TextView outputField, final DbHandler inputDb){
		return new OnClickListener() {
	    	public void onClick(View v) {
	    		Log.d("DB: ", "Truncating DB");
	    		for (Input input : inputDb.getAllInput())
	    		{
	    			if (outputField != null){
	    				outputField.setText("");
	    			}
	    			inputDb.deleteInput(input);
	    		}
	    	}
		};
	}
	
	public static OnClickListener getClearClickListener(final DbHandler inputDb){
		return getClearClickListener(null, inputDb);
	}

	public static OnClickListener getSaveClickListener(final EditText inputField, final DbHandler inputDb){
		return getSaveClickListener(inputField, null, inputDb);
	}	
	public static OnClickListener getSaveClickListener(final EditText inputField, final TextView outputField, final DbHandler inputDb){
		return new OnClickListener() {
	    	public void onClick(View v) {
	    		
	    		String input = inputField.getEditableText().toString();
    			if (outputField != null){
	    			outputField.setText("You typed: "+input);
    			}
	    		
	    		if (!input.equals("")) {
	    			Log.d("DB: ", "Writing "+input+" to DB");
	    			inputDb.addInput(new Input(input));
	    		}

	    		inputField.setText("");
			}
		};
	}
}
