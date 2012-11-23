package net.katerberg.tap.listeners;

import net.katerberg.tap.TapApplication;
import net.katerberg.tap.beans.Die;
import net.katerberg.tap.db.DbHandler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class AcceptCustomDieListener implements OnClickListener {
	DbHandler dbHandler;
	EditText nameEdit;
	EditText sizeEdit;
	EditText numberEdit;
	EditText modifierEdit;

	public AcceptCustomDieListener(EditText nameField, EditText typeField, EditText numberField, EditText modifierField) {
		dbHandler = new DbHandler(TapApplication.getAppContext());
		nameEdit = nameField;
		sizeEdit=typeField;
		numberEdit=numberField;
		modifierEdit=modifierField;
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
		if(userDie != null){
			dbHandler.addCustomDie(userDie);
			Toast toast = Toast.makeText(TapApplication.getAppContext(), "Roll Added", Toast.LENGTH_SHORT);
			toast.show(	);
			clearInputs();
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