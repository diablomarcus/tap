/*******************************************************************************
 * Copyright (c) 2012 "Mark Katerberg"
 * 
 * 
 * This file is part of Katerproject.
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
